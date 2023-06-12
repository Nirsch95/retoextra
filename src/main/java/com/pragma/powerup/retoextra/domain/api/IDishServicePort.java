package com.pragma.powerup.retoextra.domain.api;

import com.pragma.powerup.retoextra.domain.model.Dish;

import java.util.List;
import java.util.Queue;

public interface IDishServicePort {
    void saveDish(Dish dish);
    void saveDishes(List<Dish> dishList);
    Queue<Dish> getPendingDishes();
    Dish getTakeOrder();

}
