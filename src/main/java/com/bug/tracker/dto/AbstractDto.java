package com.bug.tracker.dto;

import java.io.Serializable;

public abstract class AbstractDto implements Serializable {

    protected int id;

    public AbstractDto() {
    }

    public AbstractDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
