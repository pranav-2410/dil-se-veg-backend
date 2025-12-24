package com.example.dsv.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "menu")
public class Product {

    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String category;
}
