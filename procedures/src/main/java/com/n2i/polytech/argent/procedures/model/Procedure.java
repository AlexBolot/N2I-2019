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
    private String ownerEmail;
    private Status status;

    public enum Status {
        IN_PROGRESS,
        SUCCESS,
        FAIL
    }
}
