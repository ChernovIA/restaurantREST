package com.votes.myRestaurant.controller;

import com.votes.myRestaurant.utils.ConverterFromModelToDTO;
import com.votes.myRestaurant.dto.RestaurantDTO;
import com.votes.myRestaurant.model.Restaurant;
import com.votes.myRestaurant.repository.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/admin/restaurant")
public class RestaurantController extends SimpleController<RestaurantDAO, Restaurant>{

    @Autowired
    public RestaurantController(RestaurantDAO restaurantDAO) {
        super(restaurantDAO, "Restaurant", Restaurant.class);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurant(){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertRestaurant(super.getAllEntities()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        return super.delete(id);
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestParam String name){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertRestaurant(super.add(name)));
    }

    @PutMapping
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestParam Long id, @RequestParam String name){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertRestaurant(super.update(id, name)));
    }
}
