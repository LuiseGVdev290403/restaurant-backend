package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.entitys.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<Long, Orders> {
}
