package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.entitys.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTagRepository extends JpaRepository<Long, ProductTag> {
}
