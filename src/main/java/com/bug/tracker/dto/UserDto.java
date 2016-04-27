package com.bug.tracker.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserDto implements Serializable {

    @NotNull(message="id is empty")
    private int id;

    @NotNull(message="Login is empty")
    //@Pattern(regexp ="/^[\\s\\xa0]+|[\\s\\xa0]+$/g", message = "no-no-no Whitespace!")
    @Size(min = 3, message="The length should be > 3")
    private String login;

    @NotNull(message="password is empty")
    //@Pattern(regexp ="/^[\\s\\xa0]+|[\\s\\xa0]+$/g", message = "no-no-no Whitespace!")
    @Size(min = 3, message="The length should be > 3")
    private String password;

    @NotNull(message="firstName is empty")
    //@Pattern(regexp ="/^[\\s\\xa0]+|[\\s\\xa0]+$/g", message = "no-no-no Whitespace!")
    @Size(min = 3, message="The length should be > 3")
    private String firstName;

    @NotNull(message="lastName is empty")
    //@Pattern(regexp ="/^[\\s\\xa0]+|[\\s\\xa0]+$/g", message = "no-no-no Whitespace!")
    @Size(min = 3, message="The length  should be > 3")
    private String lastName;

    @NotNull(message="email is empty")
    //@Email(message = "A given email can not exist")
    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
            "+(?:[a-zA-Z]){2,}\\.?)$",
            message = "A given email can not exist")
    private String email;

    @NotNull(message="idRole is empty")
    private int idRole;

    public UserDto() {
    }

    public UserDto(int id, String login, String password, String firstName, String lastName, String email, int idRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.idRole = idRole;
    }

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

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
