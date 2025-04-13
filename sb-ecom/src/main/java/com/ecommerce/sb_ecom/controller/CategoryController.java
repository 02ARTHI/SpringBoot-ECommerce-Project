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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.sb_ecom.Config.AppConstants;
import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;
import com.ecommerce.sb_ecom.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping("/api/public/category")
	public ResponseEntity<CategoryResponse> getAllCategories(@RequestParam(name="PageSize", defaultValue = AppConstants.Page_Size, required = false) int PageSize,
			@RequestParam(name="PageNumber" ,defaultValue = AppConstants.Page_Number, required = false) int PageNumber ,
			@RequestParam(name="sortBY" ,defaultValue = AppConstants.Sort_BY, required = false)String sortBY ,
			@RequestParam(name="sortorder" ,defaultValue = AppConstants.Sort_Order, required = false) String sortorder)
	{
		 CategoryResponse list = service.getAllCategory(PageSize, PageNumber, sortBY, sortorder);
		 return new ResponseEntity<CategoryResponse>(list,HttpStatus.OK);
	}
	
	@PostMapping("/api/public/category")
	public ResponseEntity<CategoryDTO> createCategories(@Valid @RequestBody CategoryDTO obj)
	{
		CategoryDTO categoryDTO = service.createCategory(obj);
		return new ResponseEntity<>(categoryDTO,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/api/admin/category/{id}")
	public ResponseEntity<CategoryDTO> createCategories(@PathVariable Long id)
	{
		
		CategoryDTO str=service.deleteCategory(id);
	 // return new ResponseEntity<String>(str,HttpStatus.OK);
	  //return ResponseEntity.ok(str);
	  return ResponseEntity.status(HttpStatus.OK).body(str);		
	}
	
	@PutMapping("/api/admin/category/{id}")
	public ResponseEntity<CategoryDTO> updateCategories(@RequestBody CategoryDTO catObj, @PathVariable Long id)
	{
		
		CategoryDTO obj=service.updateCategory(id, catObj);
	 // return new ResponseEntity<String>(str,HttpStatus.OK);
	  //return ResponseEntity.ok(str);
	  return ResponseEntity.status(HttpStatus.OK).body(obj);
		
	}	
}
