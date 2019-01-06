package com.votes.myRestaurant.dto;

import java.time.LocalDate;

public class VoteDTO {

    private long id;

    private LocalDate date;

    private String user;

    private String restaurant;

    public VoteDTO(long id, LocalDate date, String user, String restaurant) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.restaurant = restaurant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
