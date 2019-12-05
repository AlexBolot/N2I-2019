package com.n2i.polytech.argent.profil.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@EqualsAndHashCode
@Entity
public class Profil {
    @Id
    private String email;

    private String fistName;
    private String name;
    private int age;
    private String Ville;
}
