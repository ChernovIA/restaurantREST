package com.votes.myRestaurant.dto;

import com.votes.myRestaurant.model.Menu;

import java.time.LocalDate;

public class MenuDTO{

    private long id;

    private LocalDate date;

    private String restaurant;

    private String dish;

    public MenuDTO(long id, LocalDate date, String restaurant, String dish, int price) {
        this.id = id;
        this.date = date;
        this.restaurant = restaurant;
        this.dish = dish;
        this.price = price;
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

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;
}
