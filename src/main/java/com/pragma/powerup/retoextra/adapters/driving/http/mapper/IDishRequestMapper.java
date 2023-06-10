package com.pragma.powerup.retoextra.adapters.driving.http.mapper;

import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.retoextra.domain.model.Dish;

public interface IDishRequestMapper {
    Dish toDish(OrderRequestDto orderRequestDto);
}
