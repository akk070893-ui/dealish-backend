package com.dealish.dealish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dealish.dealish.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
