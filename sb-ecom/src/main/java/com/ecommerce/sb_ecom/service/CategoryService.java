package com.ecommerce.sb_ecom.service;

import java.util.List;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;

public interface CategoryService {

	CategoryResponse getAllCategory(int PageSize,int PageNumber, String sortby, String sortOrder);
	CategoryDTO createCategory(CategoryDTO category);
	CategoryDTO deleteCategory(Long id);
	 CategoryDTO updateCategory(Long id, CategoryDTO obj);
}
