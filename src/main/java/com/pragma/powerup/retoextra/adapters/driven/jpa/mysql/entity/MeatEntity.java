package com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("MEAT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeatEntity extends DishEntity {
    private Integer grams;
}
