package com.luisedev.restaurant.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product_categ")
public class ProductCateg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> productList;
}
