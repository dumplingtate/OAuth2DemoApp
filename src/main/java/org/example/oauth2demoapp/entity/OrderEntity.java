package org.example.oauth2demoapp.entity;

import java.util.Map;

@Entity
public class OrderEntity {
    private Long id;
    private Map<ProductEntity, Long> products;
}
