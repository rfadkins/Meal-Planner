package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @JsonIgnore
    @Transient
    private boolean activated = true;

    @Transient
    private Set<Authority> authorities = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserSavedMeals> userSavedMeals;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserSavedMealPlans> userSavedMealPlans;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserSavedRecipes> userSavedRecipes;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserSavedIngredients> userSavedIngredients;






/*
Constructors, ToString, etc below
 */
    public User (Long userID, String username, String password, String role) {
        this.userId = userID;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User(Long userId, String username, String password, Set<Authority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.activated = true;
    }

    public boolean isActivated() {
        return activated;
    }

    public Set<Authority> addRoleToAuthorities(String role) {
        this.authorities.add(new Authority("ROLE_" + role));
        setAuthorities(authorities);
        return authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                activated == user.activated &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, activated, authorities);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", activated=" + activated +
                ", authorities=" + authorities +
                '}';
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<UserSavedMeals> getUserSavedMeals() {
        return userSavedMeals;
    }

    public void setUserSavedMeals(Set<UserSavedMeals> userSavedMeals) {
        this.userSavedMeals = userSavedMeals;
    }

    public Set<UserSavedMealPlans> getUserSavedMealPlans() {
        return userSavedMealPlans;
    }

    public void setUserSavedMealPlans(Set<UserSavedMealPlans> userSavedMealPlans) {
        this.userSavedMealPlans = userSavedMealPlans;
    }

    public Set<UserSavedRecipes> getUserSavedRecipes() {
        return userSavedRecipes;
    }

    public void setUserSavedRecipes(Set<UserSavedRecipes> userSavedRecipes) {
        this.userSavedRecipes = userSavedRecipes;
    }

    public Set<UserSavedIngredients> getUserSavedIngredients() {
        return userSavedIngredients;
    }

    public void setUserSavedIngredients(Set<UserSavedIngredients> userSavedIngredients) {
        this.userSavedIngredients = userSavedIngredients;
    }
}
