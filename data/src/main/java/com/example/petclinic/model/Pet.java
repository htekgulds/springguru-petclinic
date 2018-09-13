package com.example.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    private String name;

    @ManyToOne
    private PetType type;

    @ManyToOne
    private Owner owner;

    private LocalDate birthDate;
}
