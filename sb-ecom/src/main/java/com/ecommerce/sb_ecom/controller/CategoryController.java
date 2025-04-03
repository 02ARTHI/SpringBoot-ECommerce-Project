package com.ecommerce.sb_ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping("/api/public/category")
	public List<Category> getAllCategories()
	{
		 List<Category> list = service.getAllCategory();
		 return list;
	}
	
	@PostMapping("/api/public/category")
	public String createCategories(@RequestBody Category obj)
	{
		service.createCategory(obj);
		return "category got added";
	}
	
	
}
