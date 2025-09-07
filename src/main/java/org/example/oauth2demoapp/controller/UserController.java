package org.example.oauth2demoapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.User;
import org.example.oauth2demoapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/id")
    public User findById(@RequestParam Long id) {
        User user = userService.getById(id);
        return user;
    }
}
