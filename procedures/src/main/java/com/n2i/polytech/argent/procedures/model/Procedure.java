package com.n2i.polytech.argent.procedures.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Procedure {

    @Id
    private int id;
    private Status status;
    private String ownerEmail;

    public enum Status {
        IN_PROGRESS,
        SUCCESS,
        FAIL
    }
}
