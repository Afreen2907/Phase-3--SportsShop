package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findCategoryById(long id);

}
