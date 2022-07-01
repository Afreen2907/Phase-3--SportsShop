package com.phase3Assessment.sportshop.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phase3Assessment.sportshop.persistence.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

