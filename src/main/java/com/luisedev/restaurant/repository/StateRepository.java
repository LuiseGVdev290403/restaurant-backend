package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.entitys.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<Long, State> {
}
