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
        dishEntity.setPriority(dish.getPriority());

        return dishEntity;
    }

    @Override
    public Dish toDish(DishEntity dishEntity) {
        Dish dish;
        if (dishEntity instanceof MeatEntity) {
            MeatEntity meatEntity = (MeatEntity) dishEntity;
            dish = new Meat(meatEntity.getId(), meatEntity.getDishType(), meatEntity.getPriority(), meatEntity.getGrams());
        } else if (dishEntity instanceof SoupEntity) {
            SoupEntity soupEntity = (SoupEntity) dishEntity;
            dish = new Soup(soupEntity.getId(), soupEntity.getDishType(), soupEntity.getPriority(), soupEntity.getCompanion());
        } else if (dishEntity instanceof FlanEntity) {
            FlanEntity flanEntity = (FlanEntity) dishEntity;
            dish = new Flan(flanEntity.getId(), flanEntity.getDishType(), flanEntity.getPriority(), flanEntity.getTypeDessert(), flanEntity.getTopping());
        } else if (dishEntity instanceof IceCreamEntity) {
            IceCreamEntity iceCreamEntity = (IceCreamEntity) dishEntity;
            dish = new IceCream(iceCreamEntity.getId(), iceCreamEntity.getDishType(), iceCreamEntity.getPriority(), iceCreamEntity.getTypeDessert(), iceCreamEntity.getFlavor());
        } else {
            throw new IllegalArgumentException("Invalid dish entity type");
        }

        return dish;
    }

    private MeatEntity toMeatEntity(Meat meat) {
        MeatEntity meatEntity = new MeatEntity();
        meatEntity.setGrams(meat.getGrams());
        return meatEntity;
    }

    private SoupEntity toSoupEntity(Soup soup) {
        SoupEntity soupEntity = new SoupEntity();
        soupEntity.setCompanion(soup.getCompanion());
        return soupEntity;
    }

    private FlanEntity toFlanEntity(Flan flan) {
        FlanEntity flanEntity = new FlanEntity();
        flanEntity.setTypeDessert(flan.getTypeDessert());
        flanEntity.setTopping(flan.getTopping());
        return flanEntity;
    }

    private IceCreamEntity toIceCreamEntity(IceCream iceCream) {
        IceCreamEntity iceCreamEntity = new IceCreamEntity();
        iceCreamEntity.setTypeDessert(iceCream.getTypeDessert());
        iceCreamEntity.setFlavor(iceCream.getFlavor());
        return iceCreamEntity;
    }
}