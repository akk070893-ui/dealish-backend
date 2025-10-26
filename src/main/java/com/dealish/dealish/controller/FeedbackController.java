package com.dealish.dealish.controller;

import com.dealish.dealish.model.Feedback;
import com.dealish.dealish.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping
    public List<Feedback> all() { return feedbackRepository.findAll(); }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!feedbackRepository.existsById(id)) return ResponseEntity.notFound().build();
        feedbackRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
