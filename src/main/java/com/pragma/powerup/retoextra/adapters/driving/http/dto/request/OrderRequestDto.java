package com.pragma.powerup.retoextra.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderRequestDto {
    private String dishType;
    private Integer grams;
    private String companion;
    private String dessertType;
    private String topping;
    private String flavor;
}
