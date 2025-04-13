package com.ecommerce.sb_ecom.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.sb_ecom.exceptions.ApiException;
import com.ecommerce.sb_ecom.exceptions.ResourceNotFoundException;
import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryResponse getAllCategory(int PageSize,int PageNumber, String sortby, String sortorder) {
		
		Sort SortAndOrder = sortorder.equalsIgnoreCase("asc")
				?Sort.by(sortby).ascending()
						:Sort.by(sortby).descending();
		
		Pageable pageDetails = PageRequest.of(PageNumber, PageSize,SortAndOrder);
		Page<Category> categorypage = repo.findAll(pageDetails);
		 List<Category> categories = categorypage.getContent();
		 if(categories.isEmpty())
			 throw new ApiException("No Category found till now");
		 
		 List<CategoryDTO> collect = categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class))
		 .toList();
		 
		 CategoryResponse cat= new CategoryResponse();
		 cat.setContent(collect);
		 cat.setPageNumber(categorypage.getNumber());
		 cat.setPageSize(categorypage.getSize());
		 cat.setTotalElements(categorypage.getTotalElements());
		 cat.setTotalPages(categorypage.getTotalPages());
		 cat.setLastpage(categorypage.isLast());
		 
		return cat; 
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		
		Category category = modelMapper.map(categoryDTO, Category.class);
		
		Category objFRomDB= repo.findByCategoryName(category.getCategoryName());
		if(objFRomDB!=null)
		{
			throw new ApiException("Category with name "+category.getCategoryName()+" already exists");
		}
		Category savedCatgeory = repo.save(category);
		System.out.println("category has been added");
		return modelMapper.map(savedCatgeory, CategoryDTO.class);
		
	}

	@Override
	public CategoryDTO deleteCategory(Long id) {
		 List<Category> categories = repo.findAll();
		Category cat = categories.stream().filter(c->c.getCategoryId().equals(id))
				.findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("category","categoryId",id));
		
		repo.delete(cat);
		return modelMapper.map(cat, CategoryDTO.class);
		
	}

	@Override
	public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
		
		Category category = modelMapper.map(categoryDTO, Category.class);
		
		 Category categories = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",id));
		 
		 category.setCategoryId(id);
		 categories=repo.save(category);
		 
		 return modelMapper.map(categories, CategoryDTO.class);
		 
			 
	}

}
