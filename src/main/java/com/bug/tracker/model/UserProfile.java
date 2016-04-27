package com.bug.tracker.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile extends MainEntity {

    @Column(name = "ROLE", length = 15, unique = true, nullable = false)
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserProfile that = (UserProfile) o;

        return role.equals(that.role);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "role='" + role + '\'' +
                '}';
    }
}
