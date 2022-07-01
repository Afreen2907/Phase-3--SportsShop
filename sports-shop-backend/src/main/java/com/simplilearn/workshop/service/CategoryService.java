package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.domain.Category;

public interface CategoryService {

	public Category getCategoryById(long id);
	public Category updateCategory(Category category);
	public void deleteCategory(long id);
	public List<Category> getAllCategories();
	public String getCategoriesDropDown(long id);
}
