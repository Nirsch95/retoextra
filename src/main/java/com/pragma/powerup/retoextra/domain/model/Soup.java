package com.pragma.powerup.retoextra.domain.model;

public class Soup extends Dish {
    private String companion;

    public Soup() {
        super();
    }

    public Soup(Long id, String companion) {
        super(id);
        this.companion = companion;
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }
}
