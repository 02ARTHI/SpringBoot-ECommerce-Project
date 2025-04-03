package com.ecommerce.sb_ecom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.sb_ecom.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private List<Category> categories = new ArrayList<>();
	private Long num=1L;
	
	@Override
	public List<Category> getAllCategory() {
		
		return categories;
	}

	@Override
	public void createCategory(Category category) {
		category.setCategoryId(num++);
		categories.add(category);
		System.out.println("category has been added");
		
	}

	@Override
	public String deleteCategory(Long id) {
		Category cat = categories.stream().filter(c->c.getCategoryId().equals(id)).findFirst().orElse(null);
		
		if(cat == null)
			return "category not found";
		categories.remove(cat);
		return "category with id "+id+" got deleted ";
		
	}

}
