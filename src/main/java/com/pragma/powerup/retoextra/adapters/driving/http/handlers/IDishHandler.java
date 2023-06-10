package com.pragma.powerup.retoextra.adapters.driving.http.handlers;

import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;

public interface IDishHandler {
    void saveDish(OrderRequestDto orderRequestDto);
}
