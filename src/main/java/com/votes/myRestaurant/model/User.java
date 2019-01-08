package com.votes.myRestaurant.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Model, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "userName", unique = true)
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "isEnabled")
    private boolean isEnabled;

    @Column(name = "roles")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<Vote> votes;

    public User(){

    }

    public User(long id, String password, String name) {
        this(id,password,name, null);
    }

    public User(long id, String password, String name, Set<Role> roles) {
        Set<Role> newRoles = roles;
        if (newRoles == null) {
            newRoles = new HashSet<>();
            newRoles.add(new Role());
        }

        this.id = id;
        this.password = password;
        this.name = name;
        this.roles = newRoles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public String toString() {
        return getName();
    }
}
