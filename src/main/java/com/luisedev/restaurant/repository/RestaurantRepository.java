package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.entitys.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Long, Restaurant> {
}
