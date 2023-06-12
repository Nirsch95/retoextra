package com.pragma.powerup.retoextra.domain.model;

public class Flan extends Dessert {
    private String topping;

    public Flan() {
        super();
    }

    public Flan(Long id, String dishType, Integer priority, String typeDessert, String topping) {
        super(id, dishType, priority, typeDessert);
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}
