package org.example.oauth2demoapp.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.Product;
import org.example.oauth2demoapp.entity.ProductType;
import org.example.oauth2demoapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductByType(ProductType type) {
        return productRepository.findByType(type);
    }

    public List<Product> searchProduct(String name) {
        return productRepository.findByNameContaining(name);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
