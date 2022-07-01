package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.domain.Product;

public interface ProductService {
	
	public Product getProductById(long id);
	public Product updateProduct(Product product);
	public void deleteProduct(long id);
	public List<Product> getAllProducts();

}
