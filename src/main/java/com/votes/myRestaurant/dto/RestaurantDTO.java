package com.votes.myRestaurant.dto;

public class RestaurantDTO {

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public RestaurantDTO(long id, String name) {
        this.id = id;
        this.name = name;
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

}
