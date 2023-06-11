package com.pragma.powerup.retoextra.domain.api;

import com.pragma.powerup.retoextra.domain.model.Dish;

import java.util.List;

public interface IDishServicePort {
    void saveDish(Dish dish);
    void saveDishes(List<Dish> dishList);

}
