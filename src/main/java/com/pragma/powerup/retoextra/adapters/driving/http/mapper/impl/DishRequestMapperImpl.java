package com.pragma.powerup.retoextra.adapters.driving.http.mapper.impl;

import com.pragma.powerup.retoextra.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.retoextra.adapters.driving.http.mapper.IDishRequestMapper;
import com.pragma.powerup.retoextra.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DishRequestMapperImpl implements IDishRequestMapper {

    @Override
    public Dish toDish(OrderRequestDto orderRequestDto) {
        if ( orderRequestDto == null ) {
            return null;
        }

        String dishType = orderRequestDto.getDishType();
        Dish dish;

        if ("carne".equalsIgnoreCase(dishType)) {
            Meat meat = new Meat();
            meat.setDishType(dishType);
            meat.setGrams(orderRequestDto.getGrams());
            return meat;
        } else if ("sopa".equalsIgnoreCase(dishType)) {
            Soup soup = new Soup();
            soup.setDishType(dishType);
            soup.setCompanion(orderRequestDto.getCompanion());
            return soup;
        } else if ("postre".equalsIgnoreCase(dishType)) {
            dish = createDessert(orderRequestDto);
        } else {
            throw new IllegalArgumentException("Tipo de plato desconocido: " + dishType);
        }
        return dish;
    }

    @Override
    public List<Dish> toDishes(List<OrderRequestDto> orderRequestDtos) {
        List<Dish> dishes = new ArrayList<>();
        for (OrderRequestDto orderRequestDto : orderRequestDtos) {
            Dish dish = toDish(orderRequestDto);
            dishes.add(dish);
        }
        return dishes;
    }

    private Dessert createDessert(OrderRequestDto orderRequestDto) {
        String dessertType = orderRequestDto.getDessertType();
        Dessert dessert;

        if ("flan".equalsIgnoreCase(dessertType)) {
            dessert = new Flan();
            Flan flan = (Flan) dessert;
            flan.setDishType(orderRequestDto.getDishType());
            flan.setTypeDessert(orderRequestDto.getDessertType());
            flan.setTopping(orderRequestDto.getTopping());
        } else if ("helado".equalsIgnoreCase(dessertType)) {
            dessert = new IceCream();
            IceCream iceCream = (IceCream) dessert;
            iceCream.setDishType(orderRequestDto.getDishType());
            iceCream.setTypeDessert(orderRequestDto.getDessertType());
            iceCream.setFlavor(orderRequestDto.getFlavor());
        } else {
            throw new IllegalArgumentException("Tipo de postre desconocido: " + dessertType);
        }
        return dessert;
    }
}
