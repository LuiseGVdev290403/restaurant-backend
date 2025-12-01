package com.luisedev.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "orders_id", unique = true)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductFinal productFinal;

    @Column(name = "price_unit", nullable = false)
    private double priceUnit;

    @Column(name = "price_final", nullable = false)
    private double priceFinal;

    private int qty;

    private double igv;

}
