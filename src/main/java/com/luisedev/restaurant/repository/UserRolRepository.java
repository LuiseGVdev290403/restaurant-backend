package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRol, Long> {
}
