package org.example.oauth2demoapp.repository;

import org.example.oauth2demoapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByType(String githubId);
    List<Product> findByNameContaining(String name);
}
