package com.ecommerce.sb_ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping("/api/public/category")
	public ResponseEntity<List<Category>> getAllCategories()
	{
		 List<Category> list = service.getAllCategory();
		 return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/api/public/category")
	public ResponseEntity<String> createCategories(@RequestBody Category obj)
	{
		service.createCategory(obj);
		return new ResponseEntity<String>("category got added",HttpStatus.CREATED);
			
	}
	
	@DeleteMapping("/api/admin/category/{id}")
	public ResponseEntity<String> createCategories(@PathVariable Long id)
	{
		try
		{
	  String str=service.deleteCategory(id);
	 // return new ResponseEntity<String>(str,HttpStatus.OK);
	  //return ResponseEntity.ok(str);
	  return ResponseEntity.status(HttpStatus.OK).body(str);
		}
		catch(ResponseStatusException e)
		{
			return new ResponseEntity<String>(e.getReason(),e.getStatusCode());
		}
		
	  
		
	}
	
	@PutMapping("/api/admin/category/{id}")
	public ResponseEntity<String> updateCategories(@RequestBody Category catObj, @PathVariable Long id)
	{
		try
		{
	  Category obj=service.updateCategory(id, catObj);
	 // return new ResponseEntity<String>(str,HttpStatus.OK);
	  //return ResponseEntity.ok(str);
	  return ResponseEntity.status(HttpStatus.OK).body("catgeory with id "+id+" got updated");
		}
		catch(ResponseStatusException e)
		{
			return new ResponseEntity<String>(e.getReason(),e.getStatusCode());
		}
		
	  
		
	}
	
	
}
