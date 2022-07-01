package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplilearn.workshop.domain.Product;
import com.simplilearn.workshop.service.ProductService;

public class ProductController {

	@Autowired
	private ProductService productService; 
	
	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping(path="/sports/productList")
	public List<Product> listProduct(){
		return productService.getAllProducts();
	}

}
