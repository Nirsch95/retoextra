package com.pragma.powerup.retoextra.domain.model;

public class Dessert extends Dish {
    private String typeDessert;

    public Dessert() {
        super();
    }

    public Dessert(Long id, String dishType, String typeDessert) {
        super(id, dishType);
        this.typeDessert = typeDessert;
    }

    public String getTypeDessert() {
        return typeDessert;
    }

    public void setTypeDessert(String typeDessert) {
        this.typeDessert = typeDessert;
    }
}
