package com.luisedev.restaurant.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "product_category_relation",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "categ_id")
    )
    private List<ProductCateg> categories;

    @OneToMany(mappedBy = "product")
    private List<ProductFinal> products;

}
