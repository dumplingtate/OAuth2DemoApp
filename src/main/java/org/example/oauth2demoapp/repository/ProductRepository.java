package org.example.oauth2demoapp.repository;

import org.example.oauth2demoapp.entity.Product;
import org.example.oauth2demoapp.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByType(ProductType type);
    List<Product> findByNameContaining(String name);
}
