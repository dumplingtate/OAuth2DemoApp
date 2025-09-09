package org.example.oauth2demoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private ProductType type;

}

public enum ProductType {
    ELECTRONICS, CLOTHING, BOOKS, FOOD, OTHER
}


