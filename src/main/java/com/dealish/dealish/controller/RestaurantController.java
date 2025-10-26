package com.dealish.dealish.controller;

import com.dealish.dealish.model.Restaurant;
import com.dealish.dealish.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable Integer id) {
        Optional<Restaurant> r = restaurantRepository.findById(id);
        return r.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Integer id, @RequestBody Restaurant updated) {
        return restaurantRepository.findById(id).map(r -> {
            r.setName(updated.getName());
            r.setCity(updated.getCity());
            r.setCuisineType(updated.getCuisineType());
            r.setRating(updated.getRating());
            r.setOpenTime(updated.getOpenTime());
            r.setCloseTime(updated.getCloseTime());
            restaurantRepository.save(r);
            return ResponseEntity.ok(r);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!restaurantRepository.existsById(id)) return ResponseEntity.notFound().build();
        restaurantRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
