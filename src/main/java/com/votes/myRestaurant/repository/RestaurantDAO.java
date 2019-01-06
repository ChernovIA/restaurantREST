package com.votes.myRestaurant.repository;

import com.votes.myRestaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Long> {
}
