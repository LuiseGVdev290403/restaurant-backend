package com.luisedev.restaurant.repository;

import com.luisedev.restaurant.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Long, Users> {
}
