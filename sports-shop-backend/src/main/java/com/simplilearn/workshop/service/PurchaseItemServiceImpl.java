package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.PurchaseItem;
import com.simplilearn.workshop.repository.PurchaseItemRepository;

@Service(value="purchaseItemService")
public class PurchaseItemServiceImpl implements PurchaseItemService {
	
	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
	
	public PurchaseItemServiceImpl() {
		
	}

	public PurchaseItemServiceImpl(PurchaseItemRepository purchaseItemRepository) {
		super();
		this.purchaseItemRepository = purchaseItemRepository;
	}

	@Override
	public PurchaseItem getItemById(long id) {
		// TODO Auto-generated method stub
		return purchaseItemRepository.findItemById(id);
	}

	@Override
	public List<PurchaseItem> getAllItemsByPurchaseId(long purchaseId) {
		// TODO Auto-generated method stub
		return purchaseItemRepository.findAll();
	}

	@Override
	public PurchaseItem updateItem(PurchaseItem item) {
		// TODO Auto-generated method stub
		return purchaseItemRepository.save(item);
	}

	@Override
	public void deleteItem(long id) {
		// TODO Auto-generated method stub
		purchaseItemRepository.deleteById(id);

	}


	

}
