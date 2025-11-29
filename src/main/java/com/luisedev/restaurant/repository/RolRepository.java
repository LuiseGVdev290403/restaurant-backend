package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.entitys.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Long, Rol> {
}
