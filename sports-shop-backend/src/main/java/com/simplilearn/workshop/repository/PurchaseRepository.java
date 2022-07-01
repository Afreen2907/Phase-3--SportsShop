package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
		Purchase findPurchaseById (long id);
}
