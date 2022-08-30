package com.techelevator.business;
import com.techelevator.util.BasicLogger;
import com.techelevator.model.Pantry;
import com.techelevator.model.User;
import com.techelevator.repository.PantryRepository;
import com.techelevator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.Basic;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PantryRepository pantryRepository;

    User findByUserId(Long userId){
        return userRepository.findByUserId(userId);
    }

    List<User> findAll(){
        return userRepository.findAll();
    }

    public boolean create(String username, String password) {
        User newUser = new User();
        String password_hash = new BCryptPasswordEncoder().encode(password);
        newUser.setUsername(username);
        newUser.setPassword(password_hash);
        try {
    /* Using saveAndFlush allowed us to get updated information more immediately,
    without pulling from the repository again */
            userRepository.saveAndFlush(newUser);
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
            return false;
        }
        Pantry newPantry = new Pantry();
        newPantry.setPantryId(newPantry.getPantryId());
        newPantry.setUserId(newUser.getUserId());

        try {
            pantryRepository.saveAndFlush(newPantry);
        } catch (Exception e) {

            BasicLogger.log(e.getMessage());
            return false;
        }
        return true;
    }

}
