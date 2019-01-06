package com.votes.myRestaurant.controller;

import com.votes.myRestaurant.utils.ConverterFromModelToDTO;
import com.votes.myRestaurant.dto.MenuDTO;
import com.votes.myRestaurant.model.Dish;
import com.votes.myRestaurant.model.Menu;
import com.votes.myRestaurant.model.Restaurant;
import com.votes.myRestaurant.repository.DishDAO;
import com.votes.myRestaurant.repository.MenuDAO;
import com.votes.myRestaurant.repository.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/admin/menu")
public class MenuController {

    private final MenuDAO menuDAO;
    private final RestaurantDAO restaurantDAO;
    private final DishDAO dishDAO;

    @Autowired
    public MenuController(MenuDAO menuDAO, RestaurantDAO restaurantDAO, DishDAO dishDAO) {
        this.menuDAO = menuDAO;
        this.restaurantDAO = restaurantDAO;
        this.dishDAO = dishDAO;
    }

    @GetMapping("/{restaurantId}-{localDate}")
    public ResponseEntity<List<MenuDTO>> getAllDish(@PathVariable Long restaurantId, @PathVariable LocalDate localDate){

        List<Menu> menus;

        if (localDate != null) {
            menus = menuDAO.getAllByRestaurantIdAndDate(restaurantId, localDate);
        }
        else {
            menus = menuDAO.getAllByRestaurantIdAndDate(restaurantId, LocalDate.now());
        }
        return ResponseEntity.ok(ConverterFromModelToDTO.convertMenu(menus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Menu> menu = menuDAO.findById(id);
        if (menu.isPresent()) {
            menuDAO.delete(menu.get());
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position in menu with id = "+id +" cant be deleted, not found!");
        }
        return ResponseEntity.ok("ОК");
    }

    @PostMapping
    public ResponseEntity<MenuDTO> addInMenu(@RequestParam Long restaurantId,
                                          @RequestParam Long dishId,
                                          @RequestParam LocalDate localDate,
                                          @RequestParam Integer price){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertMenu(save(null, restaurantId, dishId, localDate, price)));
    }

    @PutMapping
    public ResponseEntity<MenuDTO> updateInMenu(@RequestParam Long menuId,
                                             @RequestParam Long restaurantId,
                                             @RequestParam Long dishId,
                                             @RequestParam LocalDate localDate,
                                             @RequestParam Integer price){
        return ResponseEntity.ok(ConverterFromModelToDTO.convertMenu(save(menuId, restaurantId, dishId, localDate, price)));
    }

    private Menu save(Long menuId, Long restaurantId,
                                   Long dishId, LocalDate localDate,
                                   Integer price) {
        Optional<Menu> dishInMenuFromBase;
        if (menuId != null && menuId > 0) {
            dishInMenuFromBase = menuDAO.findById(menuId);
        }
        else{
            dishInMenuFromBase = Optional.of(new Menu());
        }

        boolean changes = false;
        if (!dishInMenuFromBase.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position in menu with id = " + menuId + " not found!");
        }

        Menu newDishInMenu = dishInMenuFromBase.get();

        if (localDate != null) {
            newDishInMenu.setDate(localDate);
            changes = true;
        }
        if (price != null && price >= 0) {
            newDishInMenu.setPrice(price);
            changes = true;
        }
        if (restaurantId != null) {
            Optional<Restaurant> restaurant = restaurantDAO.findById(restaurantId);
            if (restaurant.isPresent()) {
                newDishInMenu.setRestaurant(restaurant.get());
                changes = true;
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant with id = " + restaurantId + " not found!");
            }
        }
        if (dishId != null) {
            Optional<Dish> dish = dishDAO.findById(dishId);

            if (dish.isPresent()) {
                newDishInMenu.setDish(dish.get());
                changes = true;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish with id = " + dishId + " not found!");
            }
        }
        if (changes) {
            menuDAO.save(newDishInMenu);
        }
        return newDishInMenu;
    }
}
