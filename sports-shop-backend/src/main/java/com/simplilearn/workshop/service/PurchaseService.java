package com.simplilearn.workshop.service;


import java.util.List;

import com.simplilearn.workshop.domain.Purchase;



public interface PurchaseService {

	public Purchase getPurchaseById(long id);
	
	public List<Purchase> getAllItems();			
	
	public List<Purchase> getAllItemsByUserId(long userId);

	public Purchase  updatePurchase(Purchase purchase);
	
	public void deletePurchase(long id);

}
