package org.example.oauth2demoapp.controller.common;


import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.dto.ProductDto;
import org.example.oauth2demoapp.entity.Product;
import org.example.oauth2demoapp.entity.ProductType;
import org.example.oauth2demoapp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        if(productService.getProductById(id).isPresent()){
            return modelMapper.map(productService.getProductById(id).get(), ProductDto.class);
        }
        else{
            throw new RuntimeException("Product not found");
        }

    }

    @GetMapping("/type/{type}")
    public List<Product> getProductByType(@PathVariable ProductType type ){
        return productService.getProductByType(type);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name){
        return productService.searchProduct(name);
    }

}
