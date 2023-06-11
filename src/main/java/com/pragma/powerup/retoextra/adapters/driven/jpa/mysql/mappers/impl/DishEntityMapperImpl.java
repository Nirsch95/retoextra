package com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.mappers.impl;

import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.entity.*;
import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.retoextra.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class DishEntityMapperImpl implements IDishEntityMapper {

    @Override
    public DishEntity toEntity(Dish dish) {
        if (dish == null) {
            return null;
        }

        DishEntity dishEntity;

        if (dish instanceof Meat) {
            dishEntity = toMeatEntity((Meat) dish);
        } else if (dish instanceof Soup) {
            dishEntity = toSoupEntity((Soup) dish);
        } else if (dish instanceof Flan) {
            dishEntity = toFlanEntity((Flan) dish);
        } else if (dish instanceof IceCream) {
            dishEntity = toIceCreamEntity((IceCream) dish);
        } else {
            throw new IllegalArgumentException("Tipo de plato desconocido: " + dish.getClass().getSimpleName());
        }

        dishEntity.setId(dish.getId());
        dishEntity.setDishType(dish.getDishType());

        return dishEntity;
    }

    private MeatEntity toMeatEntity(Meat meat) {
        MeatEntity meatEntity = new MeatEntity();
        // asignar las propiedades específicas de MeatEntity
        meatEntity.setGrams(meat.getGrams());
        return meatEntity;
    }

    private SoupEntity toSoupEntity(Soup soup) {
        SoupEntity soupEntity = new SoupEntity();
        // asignar las propiedades específicas de SoupEntity
        soupEntity.setCompanion(soup.getCompanion());
        return soupEntity;
    }

    private FlanEntity toFlanEntity(Flan flan) {
        FlanEntity flanEntity = new FlanEntity();
        // asignar las propiedades específicas de FlanEntity
        flanEntity.setTypeDessert(flan.getTypeDessert());
        flanEntity.setTopping(flan.getTopping());
        return flanEntity;
    }

    private IceCreamEntity toIceCreamEntity(IceCream iceCream) {
        IceCreamEntity iceCreamEntity = new IceCreamEntity();
        // asignar las propiedades específicas de IceCreamEntity
        iceCreamEntity.setTypeDessert(iceCream.getTypeDessert());
        iceCreamEntity.setFlavor(iceCream.getFlavor());
        return iceCreamEntity;
    }
}