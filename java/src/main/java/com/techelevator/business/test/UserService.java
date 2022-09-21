//package com.techelevator.business.test;
//
//import com.techelevator.model.Authority;
//import com.techelevator.model.User;
//import com.techelevator.repository.UserRepository;
//import com.techelevator.util.BasicLogger;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//
//@Service
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    List<User> findAll(){
//        return userRepository.findAll();
//    }
//
//    public User create(String username, String password, String role) {
//        boolean userCreated = false;
//        User newUser = new User();
//
//        String password_hash = new BCryptPasswordEncoder().encode(password);
//        newUser.setUsername(username);
//        newUser.setPassword(password_hash);
//        newUser.setRole(role);
//
//        Set<Authority> authorities = new HashSet<>();
//        authorities = newUser.addRoleToAuthorities(role);   // "setAuthorities" that took in the string
//        newUser.setAuthorities(authorities);                // setAuthorities taking in the effing Authority object
//
//        userRepository.saveAndFlush(newUser);
//        try {
//            userRepository.saveAndFlush(newUser);
//            userCreated = true;
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//            userCreated = false;
//        }
//
//        return newUser;
//    }
//
//    public List<User> findAllUsers() {
//        List<User> allTheUsers = userRepository.findAll();
//        for(User user: allTheUsers) {
//            user.addRoleToAuthorities(user.getRole());
//            user.setActivated(true);
//        }
//        return allTheUsers;
//    }
//
//    public User findByUserId(Long userId) {
//        User user = userRepository.findByUserId(userId);
//        user.addRoleToAuthorities(user.getRole());
//        user.setActivated(true);
//        return user;
//    }
//
//    public User findByUsername(String username) throws UsernameNotFoundException {
//        for (User user : this.findAllUsers()) {
//            if (user.getUsername().toLowerCase().equals(username.toLowerCase())) {
//                return user;
//            }
//        }
//            throw new UsernameNotFoundException("User '" + username + "' was not found.");
//        }
//
//
//}
//
