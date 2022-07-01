package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findProductById(long id);
}
