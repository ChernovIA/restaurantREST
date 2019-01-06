package com.votes.myRestaurant.repository;

import com.votes.myRestaurant.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishDAO extends JpaRepository<Dish, Long> {
}
