package com.votes.myRestaurant.controller;

import com.votes.myRestaurant.utils.ConverterFromModelToDTO;
import com.votes.myRestaurant.dto.DishDTO;
import com.votes.myRestaurant.model.Dish;
import com.votes.myRestaurant.repository.DishDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/dish")
public class DishController extends SimpleController<DishDAO, Dish>{

    @Autowired
    public DishController(DishDAO dishDAO) {
        super(dishDAO, "Dish", Dish.class);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<DishDTO>> getAllDish(){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertDish(super.getAllEntities()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteDish(@PathVariable Long id) {
        return super.delete(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DishDTO> addDish(@RequestParam String name){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertDish(super.add(name)));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DishDTO> updateDish(@RequestParam Long id, @RequestParam String name){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertDish(super.update(id, name)));
    }

}
