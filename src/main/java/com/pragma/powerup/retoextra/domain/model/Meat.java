package com.pragma.powerup.retoextra.domain.model;

public class Meat extends Dish {
    private int grams;

    public Meat() {
        super();
    }

    public Meat(Long id, int grams) {
        super(id);
        this.grams = grams;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }
}
