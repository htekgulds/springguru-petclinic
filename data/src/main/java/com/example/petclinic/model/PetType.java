package com.example.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {
    private String name;

    public PetType(String name) {
        this.name = name;
    }
}
