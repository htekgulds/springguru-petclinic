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
@Table(name = "specialties")
public class Specialty extends BaseEntity {
    private String description;

    public Specialty(String description) {
        this.description = description;
    }
}
