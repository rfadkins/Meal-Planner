package com.techelevator.business;
import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.model.Authority;
import com.techelevator.util.BasicLogger;
//import com.techelevator.model.User;
import com.techelevator.model.User;
import com.techelevator.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;





    public User create(String username, String password, String role) {
        boolean userCreated = false;
        User newUser = new User();

        String password_hash = new BCryptPasswordEncoder().encode(password);
        newUser.setUsername(username);
        newUser.setPassword(password_hash);
        newUser.setRole(role);

        Set<Authority> authorities = new HashSet<>();

        // formerly "setAuthorities" that took in the string
        authorities = newUser.addRoleToAuthorities(newUser.getRole());

        // setAuthorities taking in the effing Authority object
        newUser.setAuthorities(authorities);
        try {
            userRepository.saveAndFlush(newUser);
            userCreated = true;
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
            userCreated = false;
        }
        return newUser;
    }

    public List<User> listAllUsers() {

        List<User> users = new ArrayList<>();
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return users;
    }

    public User findByUserId(Long userId) {

        try {
            User user = userRepository.findByUserId(userId);
            if (user == null) {
                throw new UserNotFoundException();
            } else {
                user.addRoleToAuthorities(user.getRole());
                user.setActivated(true);
                return user;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return null;
    }

    public User findByUsername(String username) throws UsernameNotFoundException {
        for (User user : this.listAllUsers()) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return user;
            }
        }
            throw new UsernameNotFoundException("User '" + username + "' was not found.");
        }


}

