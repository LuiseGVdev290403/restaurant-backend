package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.ProductFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFinalRepository extends JpaRepository<Long, ProductFinal> {
}
