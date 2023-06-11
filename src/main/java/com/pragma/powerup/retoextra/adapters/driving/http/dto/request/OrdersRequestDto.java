package com.pragma.powerup.retoextra.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrdersRequestDto {
    private List<OrderRequestDto> orders;
}
