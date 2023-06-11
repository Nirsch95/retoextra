package com.pragma.powerup.retoextra.adapters.driving.http.controller;


import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrdersRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.handlers.IDishHandler;
import com.pragma.powerup.retoextra.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final IDishHandler dishHandler;
    @Operation(summary = "Add a new Dish",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Dish created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
            })
    @PostMapping("/addOrder")
    public ResponseEntity<Map<String, String>> addOrder(@RequestBody OrderRequestDto orderRequestDto){
        dishHandler.saveDish(orderRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.DISH_CREATED_MESSAGE));
    }

    @Operation(summary = "Add a new List of Dish",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Dish created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
            })
    @PostMapping("/addOrders")
    public ResponseEntity<Map<String, String>> addOrders(@RequestBody OrdersRequestDto ordersRequestDto){
        dishHandler.saveDishes(ordersRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.DISHES_CREATED_MESSAGE));
    }
}
