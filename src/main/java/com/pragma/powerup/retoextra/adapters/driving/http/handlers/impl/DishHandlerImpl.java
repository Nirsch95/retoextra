package com.pragma.powerup.retoextra.adapters.driving.http.handlers.impl;

import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.handlers.IDishHandler;
import com.pragma.powerup.retoextra.adapters.driving.http.mapper.IDishRequestMapper;
import com.pragma.powerup.retoextra.domain.api.IDishServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishHandlerImpl implements IDishHandler {
    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;
    @Override
    public void saveDish(OrderRequestDto orderRequestDto) {
        dishServicePort.saveDish(dishRequestMapper.toDish(orderRequestDto));
    }
}