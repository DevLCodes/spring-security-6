package com.security.spring_security_6.controller;

import com.security.spring_security_6.entity.User;
import com.security.spring_security_6.repository.UserRepository;
import com.security.spring_security_6.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(
                          UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return userService.verify(user);

    }
}
