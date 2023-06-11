package com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.retoextra.domain.model.Dish;


public interface IDishEntityMapper {
    DishEntity toEntity(Dish dish);
}
