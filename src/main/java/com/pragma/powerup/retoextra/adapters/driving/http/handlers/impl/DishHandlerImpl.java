package com.pragma.powerup.retoextra.adapters.driving.http.handlers.impl;

import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrdersRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.dto.response.OrderResponseDto;
import com.pragma.powerup.retoextra.adapters.driving.http.handlers.IDishHandler;
import com.pragma.powerup.retoextra.adapters.driving.http.mapper.IDishRequestMapper;
import com.pragma.powerup.retoextra.adapters.driving.http.mapper.IDishResponseMapper;
import com.pragma.powerup.retoextra.domain.api.IDishServicePort;
import com.pragma.powerup.retoextra.domain.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishHandlerImpl implements IDishHandler {
    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;
    private final IDishResponseMapper dishResponseMapper;
    @Override
    public void saveDish(OrderRequestDto orderRequestDto) {
        dishServicePort.saveDish(dishRequestMapper.toDish(orderRequestDto));
    }

    @Override
    public void saveDishes(OrdersRequestDto ordersRequestDto) {
        dishServicePort.saveDishes(dishRequestMapper.toDishes(ordersRequestDto.getOrders()));
    }

    @Override
    public Dish getTakeOrder() {
        return dishServicePort.getTakeOrder();
    }

    @Override
    public Queue<Dish> getPendingDishes() {
        return dishServicePort.getPendingDishes();
    }

    @Override
    public List<OrderResponseDto> mapToOrderResponseList(Queue<Dish> dishes) {
        return dishes.stream()
                .map(dishResponseMapper::toResponse)
                .collect(Collectors.toList());
    }
}
