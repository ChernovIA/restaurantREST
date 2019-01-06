package com.votes.myRestaurant.controller;

import com.votes.myRestaurant.utils.ConverterFromModelToDTO;
import com.votes.myRestaurant.dto.DishDTO;
import com.votes.myRestaurant.model.Dish;
import com.votes.myRestaurant.repository.DishDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/admin/dish")
public class DishController extends SimpleController<DishDAO, Dish>{

    @Autowired
    public DishController(DishDAO dishDAO) {
        super(dishDAO, "Dish", Dish.class);
    }

    @GetMapping
    public ResponseEntity<List<DishDTO>> getAllDish(){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertDish(super.getAllEntities()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable Long id) {
        return super.delete(id);
    }

    @PostMapping
    public ResponseEntity<DishDTO> addDish(@RequestParam String name){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertDish(super.add(name)));
    }

    @PutMapping
    public ResponseEntity<DishDTO> updateDish(@RequestParam Long id, @RequestParam String name){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertDish(super.update(id, name)));
    }

}
