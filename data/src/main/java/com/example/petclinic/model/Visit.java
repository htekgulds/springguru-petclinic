package com.example.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;

    @ManyToOne
    private Pet pet;
}
