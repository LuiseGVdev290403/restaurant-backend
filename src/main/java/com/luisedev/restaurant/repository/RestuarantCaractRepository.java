package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.RestaurantCaract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestuarantCaractRepository extends JpaRepository<Long, RestaurantCaract> {
}
