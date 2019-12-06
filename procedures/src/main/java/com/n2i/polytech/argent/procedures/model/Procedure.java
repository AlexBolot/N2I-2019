package com.n2i.polytech.argent.procedures.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ownerEmail;
    private Status status;

    public enum Status {
        IN_PROGRESS,
        SUCCESS,
        FAIL
    }
}
