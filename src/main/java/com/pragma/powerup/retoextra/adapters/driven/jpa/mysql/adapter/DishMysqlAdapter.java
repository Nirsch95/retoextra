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
        dishRepository.save(dishEntityMapper.toEntity(dish));
    }

    @Override
    public void deleteDish(Dish dish){
        dishRepository.deleteById(dish.getId());
    }

    @Override
    public Queue<Dish> getPendingDishes() {
        dishQueue = createDishQueue();
        return dishQueue;
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
