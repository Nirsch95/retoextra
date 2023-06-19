package com.pragma.powerup.retoextra.domain.spi;

import com.pragma.powerup.retoextra.domain.model.Dish;

import java.util.Queue;

public interface IDishPersistencePort {
    void saveDish(Dish dish);
    Queue<Dish> getPendingDishes();
    void deleteDish(Dish dish);
}
