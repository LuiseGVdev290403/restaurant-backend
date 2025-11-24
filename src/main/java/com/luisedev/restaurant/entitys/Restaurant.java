package com.luisedev.restaurant.entitys;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;


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

    private String ubicacion;

    private String foto;
}
