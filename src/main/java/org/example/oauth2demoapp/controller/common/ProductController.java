package org.example.oauth2demoapp.controller.common;


import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.Product;
import org.example.oauth2demoapp.entity.ProductType;
import org.example.oauth2demoapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api.products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @GetMapping("/type/{type}")
    public List<Product> getProductById(@PathVariable ProductType type ){
        return productService.getProductByType(type);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name){
        return productService.searchProduct(name);
    }

}
