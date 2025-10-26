package com.dealish.dealish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dealish.dealish.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
