package com.example.demo.dto;

import com.example.demo.models.Seller;

public class ProductDTO {

    private String name;
    private Double price;
    private String category;

    public ProductDTO() {
    }

    public ProductDTO(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
