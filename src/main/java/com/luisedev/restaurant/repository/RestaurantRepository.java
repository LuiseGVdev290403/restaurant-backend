package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Long, Restaurant> {
}
