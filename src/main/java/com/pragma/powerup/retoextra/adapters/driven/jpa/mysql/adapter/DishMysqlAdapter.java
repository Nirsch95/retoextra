package com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.retoextra.domain.model.Dish;
import com.pragma.powerup.retoextra.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class DishMysqlAdapter implements IDishPersistencePort {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public void saveDish(Dish dish) {
        dishRepository.save(dishEntityMapper.toEntity(dish));
    }
}
