package org.example.oauth2demoapp.entity;

import java.util.Map;

@Entity
public class Order {
    private Long id;
    private Long userId;

    private Map<Product, Long> products; //product - key, quantity - value
}
