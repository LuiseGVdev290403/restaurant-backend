package com.luisedev.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String razonsocial;

    @Column(unique = true, length = 50)
    private String ruc;

    private String district;
    private String street;
    private String logoPhoto;

    @OneToOne
    @JoinColumn(name="restaurant_caract_id", referencedColumnName="id")
    private RestaurantCaract idCaractRestaurant;
}
