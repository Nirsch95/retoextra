package com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.retoextra.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {
    DishEntity toEntity(Dish dish);
}
