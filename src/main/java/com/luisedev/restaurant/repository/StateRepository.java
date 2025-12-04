package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
