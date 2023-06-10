package com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("ICE_CREAM")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IceCreamEntity extends DessertEntity{
    private String flavor;
}
