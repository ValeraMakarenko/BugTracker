package com.bug.tracker.model;

import javax.persistence.*;

@Entity
@Table(name = "PRIORITY")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TYPE", length = 15, unique = true, nullable = false)
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        Priority priority = (Priority) o;

        if (id != priority.id) return false;
        return type.equals(priority.type);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Priority [id=" + id + ",  type=" + type	+ "]";
    }
}
