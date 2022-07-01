package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.domain.PurchaseItem;

public interface PurchaseItemService {
	
	public PurchaseItem getItemById(long id);
	public List<PurchaseItem> getAllItemsByPurchaseId(long purchaseId);
	public PurchaseItem updateItem(PurchaseItem item);
	public void deleteItem(long id);

	
}
