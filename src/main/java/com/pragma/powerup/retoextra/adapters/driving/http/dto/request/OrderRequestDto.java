package com.pragma.powerup.retoextra.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderRequestDto {
    private String dishType;
    @Min(message = "The minimum value of grams is 250", value = 250)
    @Max(message = "The maximum value of grams is 750", value = 750)
    private Integer grams;
    private String companion;
    private String dessertType;
    private String topping;
    private String flavor;
}
