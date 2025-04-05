package com.ecommerce.sb_ecom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Override
	public List<Category> getAllCategory() {
		 List<Category> categories = repo.findAll();
		return categories;
	}

	@Override
	public void createCategory(Category category) {
		
		repo.save(category);
		System.out.println("category has been added");
		
	}

	@Override
	public String deleteCategory(Long id) {
		 List<Category> categories = repo.findAll();
		Category cat = categories.stream().filter(c->c.getCategoryId().equals(id))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
		
		repo.delete(cat);
		return "category with id "+id+" got deleted ";
		
	}

	@Override
	public Category updateCategory(Long id, Category obj) {
		 List<Category> categories = repo.findAll();
		 Optional<Category> optional = categories.stream().filter(c->c.getCategoryId().equals(id)).findFirst();
		 
		 if(optional.isPresent())
		 {
			 Category category = optional.get();
			 category.setCategoryName(obj.getCategoryName());
			 repo.save(category);
			 return category;
		 }
		 else
		 {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found");
		 }
	}

}
