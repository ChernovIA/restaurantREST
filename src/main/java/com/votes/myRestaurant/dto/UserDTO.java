package com.votes.myRestaurant.dto;

public class UserDTO {

    private long id;

    private String name;

    private String roles;

    public UserDTO(long id, String name, String roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
