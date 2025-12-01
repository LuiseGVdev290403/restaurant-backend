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

    @OneToOne
    @JoinColumn(name="restaurant_id", referencedColumnName="id")
    private Restaurant idRestaurant;

    private int floor_qty;
    private int table_qty;
    private int chair_table;
    private String qr_code;

}
