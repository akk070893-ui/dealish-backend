package com.dealish.dealish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dealish.dealish.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
