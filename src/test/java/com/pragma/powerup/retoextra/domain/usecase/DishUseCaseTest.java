package com.pragma.powerup.retoextra.domain.usecase;

import com.pragma.powerup.retoextra.domain.model.Dish;
import com.pragma.powerup.retoextra.domain.spi.IDishPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DishUseCaseTest {
    @Mock
    private IDishPersistencePort dishPersistencePort;

    private DishUseCase dishUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dishUseCase = new DishUseCase(dishPersistencePort);
    }

    @Test
    void saveDish() {
        // Arrange
        Dish dish = new Dish(1L, "Soup", 2);

        // Act
        dishUseCase.saveDish(dish);

        // Assert
        verify(dishPersistencePort, times(1)).saveDish(dish);
    }

    @Test
    void saveDishes() {
        // Arrange
        List<Dish> dishList = new ArrayList<>();
        dishList.add(new Dish(1L, "Soup", 2));
        dishList.add(new Dish(2L, "Meat", 3));

        // Act
        dishUseCase.saveDishes(dishList);

        // Assert
        verify(dishPersistencePort, times(2)).saveDish(any(Dish.class));
    }

    @Test
    void getPendingDishes() {
        // Arrange
        Queue<Dish> expectedDishes = new LinkedList<>();
        expectedDishes.add(new Dish(1L, "Soup", 2));
        expectedDishes.add(new Dish(2L, "Meat", 3));
        when(dishPersistencePort.getPendingDishes()).thenReturn(expectedDishes);

        // Act
        Queue<Dish> result = dishUseCase.getPendingDishes();

        // Assert
        assertEquals(expectedDishes, result);
        verify(dishPersistencePort, times(1)).getPendingDishes();
    }

    @Test
    void getTakeOrder() {
        // Arrange
        Dish expectedDish = new Dish(1L, "sopa", 2);
        List<Dish> dishList = new ArrayList<>();
        dishList.add(expectedDish);
        Queue<Dish> expected = new PriorityQueue<>(dishList);
        when(dishPersistencePort.getPendingDishes()).thenReturn(expected);
        doNothing().when(dishPersistencePort).deleteDish(expectedDish);

        // Act
        Dish result = dishUseCase.getTakeOrder();

        // Assert
        assertEquals(expected.peek().getId(), result.getId());
        assertEquals(expected.peek().getDishType(), result.getDishType());
        assertEquals(expected.peek().getPriority(), result.getPriority());
        verify(dishPersistencePort, times(1)).getPendingDishes();
        verify(dishPersistencePort, times(1)).deleteDish(expectedDish);
    }
}