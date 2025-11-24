package com.luisedev.restaurant.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product_final")
public class ProductFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private ProductTag tags;

    @Column(nullable = false)
    private double price;
}
