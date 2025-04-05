package com.ecommerce.sb_ecom.service;

import java.util.List;

import com.ecommerce.sb_ecom.model.Category;

public interface CategoryService {

	List<Category> getAllCategory();
	void createCategory(Category category);
	 String deleteCategory(Long id);
	Category updateCategory(Long id, Category obj);
}
