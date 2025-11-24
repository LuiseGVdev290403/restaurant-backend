package com.luisedev.restaurant.entitys;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_order", nullable = false)
    private Date dateOrder;

    @Column(name = "time_aprox", nullable = false)
    private Time timeAprox;

    @ManyToOne
    @JoinColumn(name="state_id", referencedColumnName="id")
    private State state;

    private double total;


}
