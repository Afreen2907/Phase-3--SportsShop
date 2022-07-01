package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Purchase;
import com.simplilearn.workshop.repository.PurchaseRepository;

@Service(value="purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;

	public PurchaseServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	

	public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}


	@Override
	public Purchase getPurchaseById(long id) {
		// TODO Auto-generated method stub
		return purchaseRepository.findPurchaseById(id);
	}

	@Override
	public List<Purchase> getAllItems() {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}

	@Override
	public List<Purchase> getAllItemsByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return purchaseRepository.save(purchase);
	}

	@Override
	public void deletePurchase(long id) {
		// TODO Auto-generated method stub
		purchaseRepository.deleteById(id);

	}

}
