package com.luisedev.restaurant.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product_tag")
public class ProductTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "tags")
    private List<ProductFinal> product;
}
