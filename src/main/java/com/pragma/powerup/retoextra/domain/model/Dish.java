package com.pragma.powerup.retoextra.domain.model;

public class Dish {
    private Long id;
    private String dishType;

    public Dish() {
    }

    public Dish(Long id, String dishType) {
        this.id = id;
        this.dishType = dishType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }
}
