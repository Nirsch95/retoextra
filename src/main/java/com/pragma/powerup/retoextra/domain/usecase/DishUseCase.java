package com.pragma.powerup.retoextra.domain.usecase;

import com.pragma.powerup.retoextra.domain.api.IDishServicePort;
import com.pragma.powerup.retoextra.domain.model.Dish;
import com.pragma.powerup.retoextra.domain.spi.IDishPersistencePort;

import java.util.List;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    @Override
    public void saveDish(Dish dish) {
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void saveDishes(List<Dish> dishList) {
        for (Dish dish : dishList) {
            dishPersistencePort.saveDish(dish);
        }
    }
}
