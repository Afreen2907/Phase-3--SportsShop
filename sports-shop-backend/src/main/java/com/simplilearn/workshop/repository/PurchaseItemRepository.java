package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long>{

	PurchaseItem findItemById(long id);
	void deleteByIdIn(List<PurchaseItem> listIds);
	
}
