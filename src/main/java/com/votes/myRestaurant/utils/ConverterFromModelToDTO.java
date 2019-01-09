package com.votes.myRestaurant.utils;

import com.votes.myRestaurant.dto.*;
import com.votes.myRestaurant.model.*;

import java.util.LinkedList;
import java.util.List;

public class ConverterFromModelToDTO {

    public static DishDTO convertDish(Dish dish){
        return new DishDTO(dish.getId(), dish.getName());
    }

    public static List<DishDTO> convertDish(List<Dish> dish){
        List<DishDTO> dishDTOs = new LinkedList<>();
        for(Dish dishItem: dish){
            dishDTOs.add(convertDish(dishItem));
        }
        return dishDTOs;
    }

    public static RestaurantDTO convertRestaurant(Restaurant restaurant){
        return new RestaurantDTO(restaurant.getId(), restaurant.getName());
    }

    public static List<RestaurantDTO> convertRestaurant(List<Restaurant> dish){
        List<RestaurantDTO> restaurantDTOs = new LinkedList<>();
        for(Restaurant restaurantItem: dish){
            restaurantDTOs.add(convertRestaurant(restaurantItem));
        }
        return restaurantDTOs;
    }

    public static UserDTO convertUser(User user){
        return new UserDTO(user.getId(), user.getName(), UserHelper.rolesToString(user.getRoles()));
    }

    public static List<UserDTO> convertUser(List<User> user){
        List<UserDTO> userDTOs = new LinkedList<>();
        for(User userItem: user){
            userDTOs.add(convertUser(userItem));
        }
        return userDTOs;
    }

    public static MenuDTO convertMenu(Menu menu){
        return new MenuDTO(menu.getId(), menu.getDate(),menu.getRestaurant().toString(), menu.getDish().toString(), menu.getPrice());
    }

    public static List<MenuDTO> convertMenu(List<Menu> menu){
        List<MenuDTO> menuDTOS = new LinkedList<>();
        for(Menu menuItem: menu){
            menuDTOS.add(convertMenu(menuItem));
        }
        return menuDTOS;
    }

    public static VoteDTO convertVote(Vote vote){
        return new VoteDTO("Your vote for "+ vote.getRestaurant().getName() + " was counted");
    }

    public static List<VoteDTO> convertVote(List<Vote> vote){
        List<VoteDTO> voteDTOs = new LinkedList<>();
        for(Vote voteItem: vote){
            voteDTOs.add(convertVote(voteItem));
        }
        return voteDTOs;
    }
}
