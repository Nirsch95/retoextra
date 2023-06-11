package com.pragma.powerup.retoextra.adapters.driving.http.handlers;

import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrdersRequestDto;

public interface IDishHandler {
    void saveDish(OrderRequestDto orderRequestDto);
    void saveDishes(OrdersRequestDto ordersRequestDto);
}
