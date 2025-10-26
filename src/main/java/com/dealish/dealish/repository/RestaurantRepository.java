package com.dealish.dealish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dealish.dealish.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
