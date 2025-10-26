package com.dealish.dealish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dealish.dealish.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
