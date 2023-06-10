package com.pragma.powerup.retoextra.domain.model;

public class IceCream extends Dessert{
    private String flavor;

    public IceCream() {
        super();
    }

    public IceCream(Long id, String dishType, String typeDessert, String flavor) {
        super(id, dishType, typeDessert);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
