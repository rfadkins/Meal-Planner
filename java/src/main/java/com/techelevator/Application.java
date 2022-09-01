package com.techelevator;

import com.techelevator.business.UserService;
import com.techelevator.model.User;
import com.techelevator.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.techelevator")
public class Application {
//    User testUser = new User();
//    UserRepository userRepository;
//    UserService userService;
//
//    public Long makingANewUser() {
//        userService.create("TestUsername", "TestPassword");
//        return testUser.getUserId();
//    }


    public static void main(String[] args) {
//        Application application = new Application();
//
//        Long makingANewUserId = application.makingANewUser();

        SpringApplication.run(Application.class, args);


    }


//    private void handleRegister() {
//        System.out.println("Please register a new user account");
//        UserCredentials credentials = consoleService.promptForCredentials();
//        if (authenticationService.register(credentials)) {
//            System.out.println("Registration successful. You can now login.");
//        } else {
//            consoleService.printErrorMessage();
//        }
//    }




}
