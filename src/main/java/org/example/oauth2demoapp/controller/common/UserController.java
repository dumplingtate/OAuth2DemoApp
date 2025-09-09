package org.example.oauth2demoapp.controller.common;

import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.User;
import org.example.oauth2demoapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Optional<User> findById(@RequestParam Long id) {
        return userService.findById(id);
    }
}
