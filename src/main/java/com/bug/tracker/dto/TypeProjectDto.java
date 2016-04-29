package com.bug.tracker.dto;

public class TypeProjectDto extends AbstractDto {

    private String type;

    public TypeProjectDto(int id, String type) {
        super(id);
        this.type = type;
    }

    public TypeProjectDto() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
