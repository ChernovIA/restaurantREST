package com.votes.myRestaurant.controller;

import com.votes.myRestaurant.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

abstract class SimpleController<T extends JpaRepository<V, Long>, V extends Model> {

    private T implementDAO;
    private String className;
    private Class<V> clazz;

    public T getImplementDAO() {
        return implementDAO;
    }

    public void setImplementDAO(T implementDAO) {
        this.implementDAO = implementDAO;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    SimpleController(T implementDAO, String className, Class<V> clazz) {
        this.implementDAO = implementDAO;
        this.className = className;
        this.clazz = clazz;
    }

    List<V> getAllEntities(){
        try {
            return implementDAO.findAll();
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cant get list of " + getClassName(), ex);
        }
    }

    ResponseEntity<String> delete(Long id) {
        Optional<V> entity = implementDAO.findById(id);
        if (entity.isPresent()) {
            implementDAO.delete(entity.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, getClassName() + " with id = " + id + " cant be deleted, not found!");
        }
        return ResponseEntity.ok("ОК");
    }

    V add(String name){
        return save(null, name);
    }

    V update(Long id, String name){
        if (id != null && id > 0) {
            return save(id, name);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Cant update "+getClassName()+", id is missing!");
    }

    private V save(Long id, String name) {
        V entity;
        try {
            entity = (V)clazz.getDeclaredConstructors()[0].newInstance(new Object[]{});
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cant create model class "+getClassName()+"!");
        }

        String operation = "create";

        if (id != null && id > 0) {
            Optional<V> optEntity = implementDAO.findById(id);
            if (optEntity.isPresent()) {
                entity = optEntity.get();
            }
            else{
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Cant find "+getClassName()+" with id = "+ id +"!");
            }
            operation = "update";
        }
        if (name != null && !name.isEmpty()) {
                entity.setName(name);
        }
        else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cant "+operation+" "+getClassName()+" with name - "+ name);
        }
        try {
            implementDAO.save(entity);
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error while " + operation + " " + getClassName() + "!", ex);
        }

        return entity;
    }
}
