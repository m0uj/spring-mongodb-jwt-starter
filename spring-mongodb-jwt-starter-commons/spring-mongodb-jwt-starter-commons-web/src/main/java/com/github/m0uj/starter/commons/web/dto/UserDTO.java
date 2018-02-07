package com.github.m0uj.starter.commons.web.dto;

/**
 * Created by m0uj on 4/10/17.
 */
public class UserDTO extends AbstractDTO {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
