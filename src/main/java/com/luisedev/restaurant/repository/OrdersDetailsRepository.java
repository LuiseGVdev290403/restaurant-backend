package com.luisedev.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<Long, OrdersRepository> {
}
