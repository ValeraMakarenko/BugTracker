package com.bug.tracker.model;

import javax.persistence.*;

@Entity
@Table(name = "STATUS")
public class Status extends AbstractEntity {

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

        Status status = (Status) o;

        return type.equals(status.type);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
