package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Long, Orders> {
}
