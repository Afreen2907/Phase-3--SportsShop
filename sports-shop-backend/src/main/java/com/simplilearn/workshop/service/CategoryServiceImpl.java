package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Category;
import com.simplilearn.workshop.repository.CategoryRepository;

@Service(value="categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository  categoryRepository;
	
	
	public CategoryServiceImpl() {
	
	}
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findCategoryById(id);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		 categoryRepository.deleteById(id);
		
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public String getCategoriesDropDown(long id) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("");
		List<Category> list = categoryRepository.findAll();
		 for(Category cat: list) {
			 if (cat.getId() == id)
				 sb.append("<option value=" + String.valueOf(cat.getId()) + " selected>" + cat.getName() + "</option>");
			 else
				 sb.append("<option value=" + String.valueOf(cat.getId()) + ">" + cat.getName() + "</option>");
				 
		 }
		 return sb.toString();
	}

}
