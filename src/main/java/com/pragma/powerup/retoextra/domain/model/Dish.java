package com.pragma.powerup.retoextra.domain.model;

public class Dish implements Comparable<Dish>{
    private Long id;
    private String dishType;
    private Integer priority;

    public Dish() {
    }

    public Dish(Long id, String dishType, Integer priority) {
        this.id = id;
        this.dishType = dishType;
        this.priority = priority;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Dish other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
