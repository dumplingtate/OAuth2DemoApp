package org.example.oauth2demoapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.Order;
import org.example.oauth2demoapp.entity.User;
import org.example.oauth2demoapp.service.OrderService;
import org.example.oauth2demoapp.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
    public Order createOrder(@AuthenticationPrincipal OAuth2User principal,
                             @RequestBody Map<Long,Integer> productQuantites){
        String email = principal.getAttribute("email").toString();
        String username = principal.getAttribute("login").toString();
        String githubId = principal.getAttribute("id").toString();

        User user = userService.findOrCreateUser(username, email, githubId);
        return orderService.createOrder(user, productQuantites);
    }

    @GetMapping
    public List<Order> getUsersOrders(@AuthenticationPrincipal OAuth2User principal){
        String githubId = principal.getAttribute("id").toString();

        User user = userService.findOrCreateUser(
                principal.getAttribute("login").toString(),
                principal.getAttribute("email").toString(),
                githubId);

        return orderService.getUserOrders(user);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id,  @AuthenticationPrincipal OAuth2User principal){
        String githubId = principal.getAttribute("id").toString();

        User user = userService.findOrCreateUser(
                principal.getAttribute("login").toString(),
                principal.getAttribute("email").toString(),
                githubId);

        return orderService.findById(id)
                .filter(order -> order.getUser().getId().equals(user.getId()))
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}