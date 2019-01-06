package com.votes.myRestaurant.init;

import com.votes.myRestaurant.model.Role;
import com.votes.myRestaurant.model.RoleType;
import com.votes.myRestaurant.model.User;
import com.votes.myRestaurant.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class DataInitializer {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void init() {
        User user = (User)userDAO.findByName("admin");

        if (user == null){
            user = new User();
            user.setEnabled(true);
            user.setName("admin");
            user.setPassword(passwordEncoder.encode("adminPass"));

            Role roleAdm = new Role();
            roleAdm.setType(RoleType.ADMIN);

            Set<Role> roles = new HashSet<>();
            roles.add(roleAdm);
            user.setRoles(roles);

            userDAO.save(user);
        }
    }
}
