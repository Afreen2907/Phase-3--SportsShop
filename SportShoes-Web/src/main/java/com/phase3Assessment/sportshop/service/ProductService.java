package com.phase3Assessment.sportshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3Assessment.sportshop.persistence.model.Product;
import com.phase3Assessment.sportshop.persistence.repo.ProductRepository;



@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct(){return  productRepository.findAll();}
	public void addProduct(Product product) {productRepository.save(product);}
	public void removeProductById(long id) {productRepository.deleteById(id);}
	public Optional<Product> getProductById(Long id){return productRepository.findById(id);}
	
	public List<Product> getAllProductsByCategoryId(int id){
		return productRepository.findAllByCategory_Id(id);
	}
	
	
	
}
