package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OderDetail, Long> {
}
