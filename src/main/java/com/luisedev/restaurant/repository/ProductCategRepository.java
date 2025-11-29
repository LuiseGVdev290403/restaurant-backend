package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.entitys.ProductCateg;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategRepository extends JpaRepository<Long, ProductCateg> {
}
