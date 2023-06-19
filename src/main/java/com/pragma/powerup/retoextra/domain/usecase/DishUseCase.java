package com.pragma.powerup.retoextra.domain.usecase;

import com.pragma.powerup.retoextra.domain.api.IDishServicePort;
import com.pragma.powerup.retoextra.domain.model.*;
import com.pragma.powerup.retoextra.domain.spi.IDishPersistencePort;

import java.util.List;
import java.util.Queue;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

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
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void saveDishes(List<Dish> dishList) {
        for (Dish dish : dishList) {
            dishPersistencePort.saveDish(dish);
        }
    }

    @Override
    public Queue<Dish> getPendingDishes() {
        return dishPersistencePort.getPendingDishes();
    }

    @Override
    public Dish getTakeOrder() {
        Queue<Dish> pedingDishes = dishPersistencePort.getPendingDishes();
        if (pedingDishes.isEmpty()){
            return new Dish();
        }
        Dish dishPriority = pedingDishes.poll();
        dishPersistencePort.deleteDish(dishPriority);
        return dishPriority;
    }
}
