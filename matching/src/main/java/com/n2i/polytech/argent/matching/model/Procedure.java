package com.n2i.polytech.argent.matching.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Procedure {

    private int id;
    private String ownerEmail;
    private Status status;

    public enum Status {
        IN_PROGRESS,
        SUCCESS,
        FAIL
    }
}