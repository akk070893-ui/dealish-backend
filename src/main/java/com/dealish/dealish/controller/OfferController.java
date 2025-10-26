package com.dealish.dealish.controller;

import com.dealish.dealish.model.Offer;
import com.dealish.dealish.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    @GetMapping
    public List<Offer> all() { return offerRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> one(@PathVariable Integer id) {
        Optional<Offer> o = offerRepository.findById(id);
        return o.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Offer create(@RequestBody Offer offer) {
        return offerRepository.save(offer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!offerRepository.existsById(id)) return ResponseEntity.notFound().build();
        offerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
