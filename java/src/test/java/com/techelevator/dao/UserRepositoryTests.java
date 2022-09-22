package com.techelevator.dao;

import com.techelevator.business.UserService;
import com.techelevator.model.Authority;
import com.techelevator.model.User;
import com.techelevator.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    private TestEntityManager testEntityManager;

//
//    @Test
//    public void userIdIsGreaterThanZero() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .build();
//        user = userService.create(user.getUsername(), user.getPassword(), user.getRole());
//
//        Assertions.assertThat(user.getUserId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void userHasRole() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .role("USER")
//                .build();
//        user = userService.create(user.getUsername(), user.getPassword(), user.getRole());
//
//        Assertions.assertThat(user.getAuthorities()).isNotNull();
//    }
//
//    @Test
//    public void userHasAuthorities() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .role("USER")
//                .build();
//        user = userService.create(user.getUsername(), user.getPassword(), user.getRole());
//        Set<Authority> authorities = new HashSet<>();
//        authorities= user.getAuthorities();
//        Assertions.assertThat(authorities).isNotNull();
//    }

//    @Test
//    public void userIdIsNotNull() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .build();
//        user = userService.create(user.getUsername(), user.getPassword(), user.getRole());
//
//        Assertions.assertThat(user.getUserId()).isNotNull();
//    }



}


