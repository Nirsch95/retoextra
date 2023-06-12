package com.pragma.powerup.retoextra.adapters.driving.http.controller;

import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrdersRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.handlers.IDishHandler;
import com.pragma.powerup.retoextra.configuration.Constants;
import com.pragma.powerup.retoextra.domain.model.Dish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.*;

class OrderControllerTest {

    private IDishHandler dishHandler;
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        dishHandler = mock(IDishHandler.class);
        orderController = new OrderController(dishHandler);
    }

    @Test
    void testGetPendingOrders() {
        // Arrange
        Queue<Dish> pendingDishes = new PriorityQueue<>();
        pendingDishes.add(new Dish(1L,"carne",300));
        pendingDishes.add(new Dish(2L,"carne",400));
        when(dishHandler.getPendingDishes()).thenReturn(pendingDishes);

        // Act
        ResponseEntity<List<Dish>> response = orderController.getPendingOrders();

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetTakeOrder() {
        // Arrange
        Dish order = new Dish();
        when(dishHandler.getTakeOrder()).thenReturn(order);

        // Act
        ResponseEntity<Dish> response = orderController.getTakeOrder();

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(order.getId(), response.getBody().getId());
        Assertions.assertEquals(order.getDishType(), response.getBody().getDishType());
        Assertions.assertEquals(order.getPriority(), response.getBody().getPriority());
    }

    @Test
    void testAddOrder() {
        // Arrange
        OrderRequestDto orderRequestDto = new OrderRequestDto("carne", 300, null,
                null, null, null);
        doNothing().when(dishHandler).saveDish(orderRequestDto);

        // Act
        ResponseEntity<Map<String, String>> response = orderController.addOrder(orderRequestDto);

        // Assert
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.DISH_CREATED_MESSAGE), response.getBody());
        verify(dishHandler, times(1)).saveDish(orderRequestDto);
    }

    @Test
    void testAddOrders() {
        // Arrange
        OrdersRequestDto ordersRequestDto = new OrdersRequestDto(Arrays.asList(new OrderRequestDto("carne",
                300, null, null, null, null),
                new OrderRequestDto("carne", 400, null, null, null,
                        null)));
        doNothing().when(dishHandler).saveDishes(ordersRequestDto);

        // Act
        ResponseEntity<Map<String, String>> response = orderController.addOrders(ordersRequestDto);

        // Assert
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.DISHES_CREATED_MESSAGE), response.getBody());
        verify(dishHandler, times(1)).saveDishes(ordersRequestDto);
    }
}