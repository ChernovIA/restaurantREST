package com.votes.myRestaurant.init;

import com.votes.myRestaurant.model.*;
import com.votes.myRestaurant.repository.DishDAO;
import com.votes.myRestaurant.repository.MenuDAO;
import com.votes.myRestaurant.repository.RestaurantDAO;
import com.votes.myRestaurant.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DataInitializer {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DishDAO dishDAO;

    @Autowired
    private RestaurantDAO restaurantDAO;

    @Autowired
    private MenuDAO menuDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void init() {
        //add admin
        User user = new User();
        user.setEnabled(true);
        user.setName("admin");
        user.setPassword(passwordEncoder.encode("adminPass"));

        Role roleAdm = new Role();
        roleAdm.setType(RoleType.ADMIN);

        Set<Role> roles = new HashSet<>();
        roles.add(roleAdm);
        user.setRoles(roles);

        userDAO.save(user);

        //add dish

        Dish dishPizza = new Dish();
        dishPizza.setName("Pizza");
        dishDAO.save(dishPizza);

        Dish dishSoup = new Dish();
        dishSoup.setName("Soup");
        dishDAO.save(dishSoup);

        Dish dishSausage = new Dish();
        dishSausage.setName("Sausage");
        dishDAO.save(dishSausage);

        //add reataurant

        Restaurant restaurantKF = new Restaurant();
        restaurantKF.setName("Karl fridrish");
        restaurantDAO.save(restaurantKF);

        Restaurant restaurantPH = new Restaurant();
        restaurantPH.setName("PizzaHat");
        restaurantDAO.save(restaurantPH);

        //add menu
        //first rest
        Menu menuPos1 = new Menu();
        menuPos1.setDish(dishSoup);
        menuPos1.setRestaurant(restaurantKF);
        menuPos1.setPrice(300);
        menuPos1.setDate(LocalDate.now());

        Menu menuPos2 = new Menu();
        menuPos2.setDish(dishSausage);
        menuPos2.setRestaurant(restaurantKF);
        menuPos2.setPrice(600);
        menuPos2.setDate(LocalDate.now());

        //second rest
        Menu menuPos3 = new Menu();
        menuPos3.setDish(dishSoup);
        menuPos3.setRestaurant(restaurantPH);
        menuPos3.setPrice(120);
        menuPos3.setDate(LocalDate.now());

        Menu menuPos4 = new Menu();
        menuPos4.setDish(dishPizza);
        menuPos4.setRestaurant(restaurantPH);
        menuPos4.setPrice(800);
        menuPos4.setDate(LocalDate.now());

        menuDAO.save(menuPos1);
        menuDAO.save(menuPos2);
        menuDAO.save(menuPos3);
        menuDAO.save(menuPos4);
    }
}
