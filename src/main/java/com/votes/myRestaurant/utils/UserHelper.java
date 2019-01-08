package com.votes.myRestaurant.utils;

import com.votes.myRestaurant.model.Role;
import com.votes.myRestaurant.model.RoleType;
import com.votes.myRestaurant.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserHelper {

    public static void SetUserPermission(User user, RoleType roleType){
        Role roleAdmin = new Role();
        roleAdmin.setType(roleType);
        Set<Role> newRoles = new HashSet<>();
        newRoles.add(roleAdmin);
        user.setRoles(newRoles);
    }

    public static String rolesToString(Set<Role> roles){
        return roles.stream()
                .map(s->s.getType().name())
                .collect(Collectors.joining(", "));
    }
}
