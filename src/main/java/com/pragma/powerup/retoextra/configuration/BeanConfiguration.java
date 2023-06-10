package com.pragma.powerup.retoextra.configuration;

import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.adapter.DishMysqlAdapter;
import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.retoextra.domain.usecase.DishUseCase;
import com.pragma.powerup.retoextra.domain.api.IDishServicePort;
import com.pragma.powerup.retoextra.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;


    @Bean
    public IDishServicePort userServicePort() {
        return new DishUseCase(dishPersistencePort());
    }
    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishMysqlAdapter(dishRepository, dishEntityMapper);
    }
}
