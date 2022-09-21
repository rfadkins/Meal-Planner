package com.techelevator.model.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techelevator.model.Authority;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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


    @OneToMany(mappedBy = "user")
    private Set<UserSavedMeals> userSavedMeals;

    @OneToMany(mappedBy = "user")
    private Set<UserSavedMealPlans> userSavedMealPlans;

    @OneToMany(mappedBy = "user")
    private Set<UserSavedRecipes> userSavedRecipes;

    @OneToMany(mappedBy = "user")
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
        com.techelevator.model.test.User user = (com.techelevator.model.test.User) o;
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
}
