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
@Table(name = "user_rol")
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private Users idUSer;

    @ManyToOne
    @JoinColumn(name = "id_rol",referencedColumnName = "id")
    private Rol idRol;
}
