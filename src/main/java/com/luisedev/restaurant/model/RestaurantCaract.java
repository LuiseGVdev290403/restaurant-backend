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
@Table(name = "restaurant_caract")
public class RestaurantCaract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "floor_qty")
    private int floorQty;

    @Column(name = "table_qty")
    private int tableQty;

    @Column(name = "chair_table")
    private int chairTable;

    @Column(name = "qr_code")
    private String qr_code;

}
