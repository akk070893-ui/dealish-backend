package com.dealish.dealish.controller;

import com.dealish.dealish.model.OrderEntity;
import com.dealish.dealish.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<OrderEntity> all() { return orderRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> one(@PathVariable Integer id) {
        Optional<OrderEntity> o = orderRepository.findById(id);
        return o.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderEntity create(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!orderRepository.existsById(id)) return ResponseEntity.notFound().build();
        orderRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
