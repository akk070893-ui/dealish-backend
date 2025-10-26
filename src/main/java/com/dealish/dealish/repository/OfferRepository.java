package com.dealish.dealish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dealish.dealish.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
