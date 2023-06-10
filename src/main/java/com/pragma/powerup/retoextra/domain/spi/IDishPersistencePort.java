package com.pragma.powerup.retoextra.domain.spi;

import com.pragma.powerup.retoextra.domain.model.Dish;

public interface IDishPersistencePort {
    void saveDish(Dish dish);
}
