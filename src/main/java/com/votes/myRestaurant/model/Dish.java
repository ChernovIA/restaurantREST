package com.votes.myRestaurant.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "dish")
    private List<Menu> menu;

    public Dish(){

    }

    public Dish(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
