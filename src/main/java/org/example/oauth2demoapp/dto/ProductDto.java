package org.example.oauth2demoapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
public class ProductDto {

    private String name;
    private String description;
    private Double price;
}
