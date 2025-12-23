package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrderDetail, Long> {
}
