package com.bug.tracker.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "LOGIN", unique = true, nullable = false)
    private String login;

    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_USER_PROFILE",
            joinColumns = {@JoinColumn(name = "FK_USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FK_USER_PROFILE_ID")})
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
/*
    @OneToMany(mappedBy = "User")
    private Set<BugReport> bugReports;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }
/*

    public Set<BugReport> getBugReports() {
        return bugReports;
    }

    public void setBugReports(Set<BugReport> bugReports) {
        this.bugReports = bugReports;
    }
*/

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", userProfiles=" + userProfiles + "]";
    }

}
