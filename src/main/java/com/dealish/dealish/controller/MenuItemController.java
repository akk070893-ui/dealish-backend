package com.dealish.dealish.controller;

import com.dealish.dealish.model.MenuItem;
import com.dealish.dealish.model.Restaurant;
import com.dealish.dealish.repository.MenuItemRepository;
import com.dealish.dealish.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public List<MenuItem> all() { return menuItemRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> one(@PathVariable Integer id) {
        Optional<MenuItem> m = menuItemRepository.findById(id);
        return m.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MenuItem> create(@RequestBody MenuItem menuItem) {
        if (menuItem.getRestaurant() != null && menuItem.getRestaurant().getRestaurantId() != null) {
            Optional<Restaurant> r = restaurantRepository.findById(menuItem.getRestaurant().getRestaurantId());
            if (r.isPresent()) {
                menuItem.setRestaurant(r.get());
                return ResponseEntity.ok(menuItemRepository.save(menuItem));
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!menuItemRepository.existsById(id)) return ResponseEntity.notFound().build();
        menuItemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
