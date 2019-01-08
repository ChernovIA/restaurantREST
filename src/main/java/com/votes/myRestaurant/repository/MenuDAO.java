package com.votes.myRestaurant.repository;

import com.votes.myRestaurant.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuDAO extends JpaRepository<Menu, Long> {
    List<Menu> getAllByRestaurantIdAndDateOrderByDish(Long id, LocalDate localDate);
}
