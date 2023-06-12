package com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.retoextra.domain.model.*;
import com.pragma.powerup.retoextra.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Transactional
public class DishMysqlAdapter implements IDishPersistencePort {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;
    private Queue<Dish> dishQueue;

    @Override
    public void saveDish(Dish dish) {
        if (dish.getPriority() == null) {
            if (dish instanceof Meat) {
                dish.setPriority(((Meat) dish).getGrams());
            } else if (dish instanceof Soup) {
                String companion = ((Soup) dish).getCompanion();
                if (companion.equalsIgnoreCase("yuca")) {
                    dish.setPriority(5);
                } else if (companion.equalsIgnoreCase("papa")) {
                    dish.setPriority(4);
                } else if (companion.equalsIgnoreCase("arroz")) {
                    dish.setPriority(3);
                }
            } else if (dish instanceof Flan) {
                dish.setPriority(2);
            } else if (dish instanceof IceCream) {
                dish.setPriority(1);
            }
        }
        dishRepository.save(dishEntityMapper.toEntity(dish));
    }

    @Override
    public Queue<Dish> getPendingDishes() {
        if (dishQueue == null) {
            dishQueue = createDishQueue();
        }
        return dishQueue;
    }

    @Override
    public Dish getTakeOrder() {
        Queue<Dish> pendingDishes = getPendingDishes();
        if(pendingDishes.isEmpty()){
            return new Dish();
        }
        Dish dishPriority = pendingDishes.poll();
        dishRepository.deleteById(dishPriority.getId());
        return dishPriority;
    }

    private Queue<Dish> createDishQueue() {
        List<Dish> dishList = getDishListFromRepository();
        return new PriorityQueue<>(dishList);
    }

    private List<Dish> getDishListFromRepository() {
        List<DishEntity> dishEntities = dishRepository.findAll();
        List<Dish> dishList = new ArrayList<>();
        for (DishEntity dishEntity : dishEntities) {
            Dish dish = dishEntityMapper.toDish(dishEntity);
            dishList.add(dish);
        }
        return dishList;
    }
}
