package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Product;
import com.simplilearn.workshop.repository.ProductRepository;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl() {
		
	}
	
	

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}



	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return productRepository.findProductById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);

	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);

	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	

}
