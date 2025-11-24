package com.luisedev.restaurant.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="last_name")
    private String lastName;
    @Column(length = 20)
    private String dni;
    private String direction;
    private String district;
}
