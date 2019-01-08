package com.votes.myRestaurant.controller;

import com.votes.myRestaurant.model.RoleType;
import com.votes.myRestaurant.utils.ConverterFromModelToDTO;
import com.votes.myRestaurant.dto.UserDTO;
import com.votes.myRestaurant.model.User;
import com.votes.myRestaurant.repository.UserDAO;
import com.votes.myRestaurant.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserController extends SimpleController<UserDAO, User> {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserDAO implementDAO, PasswordEncoder passwordEncoder) {
        super(implementDAO, "USER", User.class);
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(ConverterFromModelToDTO.convertUser(super.getAllEntities()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (id == 1){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Admin cant be deleted!");
        }
        return super.delete(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> addUser(@RequestParam String name,
                                           @RequestParam String password,
                                           @RequestParam Boolean isAdmin) {
        return ResponseEntity.ok(ConverterFromModelToDTO.convertUser(save(null, name, password, isAdmin)));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> updateUser(@RequestParam Long id,
                                              @RequestParam String name,
                                              @RequestParam String password,
                                              @RequestParam Boolean isAdmin) {
        if (id != null && id > 0) {
            return ResponseEntity.ok(ConverterFromModelToDTO.convertUser(save(id, name, password, isAdmin)));
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Cant update "+this.getClassName()+", id is missing!");
    }

    private User save(Long id, String name, String password, Boolean isAdmin) {
        User entity = new User();

        if (isAdmin){
            UserHelper.SetUserPermission(entity, RoleType.ADMIN);
        }
        else{
            UserHelper.SetUserPermission(entity, RoleType.USER);
        }

        String operation = "create";

        if (id != null && id > 0) {
            entity.setId(id);
            operation = "update";
        }
        else {
            entity.setEnabled(true);
        }

        if (name != null && !name.isEmpty()) {
            entity.setName(name);
        }

        if (password != null && !password.isEmpty()) {
            entity.setPassword(passwordEncoder.encode(password));
        }

        try {
            getImplementDAO().save(entity);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cant "+operation+" "+getClassName()+" with name - "+ name, ex);
        }
        return entity;
    }
}
