package com.bug.tracker.model;

import javax.persistence.*;

@Entity
@Table(name = "PRIORITY")
public class Priority extends MainEntity {

    @Column(name = "TYPE", length = 15, unique = true, nullable = false)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Priority priority = (Priority) o;

        return type.equals(priority.type);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "type='" + type + '\'' +
                '}';
    }
}
