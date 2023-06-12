package com.pragma.powerup.retoextra.domain.model;

public class Meat extends Dish {
    private Integer grams;

    public Meat() {
        super();
    }

    public Meat(Long id, String dishType, Integer priority, Integer grams) {
        super(id, dishType, priority);
        this.grams = grams;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(Integer grams) {
        this.grams = grams;
    }
}
