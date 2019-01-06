package com.votes.myRestaurant.repository;

import com.votes.myRestaurant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long>, UserDetailsService {

    User findByName(String name);

    @Override
    default UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByName(s);
        if(user == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return user;
    }
}
