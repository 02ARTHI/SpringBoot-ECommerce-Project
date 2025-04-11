package com.ecommerce.sb_ecom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sb_ecom.exceptions.ResourceNotFoundException;
import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.payload.ProductDTO;
import com.ecommerce.sb_ecom.payload.ProductResponse;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import com.ecommerce.sb_ecom.repositories.Productrepositories;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private Productrepositories repo;
	
	@Autowired
	private CategoryRepository repoCat;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDTO addProduct(Product product, Long categoryId) {
		System.out.println("before calling imp");
		Category categoryObj = repoCat.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category","categoryId", categoryId));
		
		System.out.println("cat obj"+categoryObj);
		
		product.setCategory(categoryObj);
		product.setImage("default.png");
		double specialPrice = product.getPrice()-
				((product.getDiscount()*0.01)* product.getPrice());
		
		product.setSpecialPrice(specialPrice);
		Product savedProduct = repo.save(product);
		
		return modelMapper.map(savedProduct, ProductDTO.class);
	}

	@Override
	public ProductResponse getAllProducts() {
		List<Product> listOfProducts = repo.findAll();
		List<ProductDTO> productDTO = listOfProducts.stream()
				.map(product -> modelMapper.map(product, ProductDTO.class))
						.collect(Collectors.toList());
		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productDTO);
		return productResponse;
	}

	@Override
	public ProductResponse getAllProductsByCategory(Long categoryId) {
		Category categoryObj = repoCat.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category","categoryId", categoryId));
		
		List<Product> listOfProducts = repo.findByCategoryOrderByPriceAsc(categoryObj);
		
		List<ProductDTO> productDTO = listOfProducts.stream()
				.map(product -> modelMapper.map(product, ProductDTO.class))
						.collect(Collectors.toList());
		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productDTO);
		return productResponse;
	}

	@Override
	public ProductResponse searchProductsByKeyword(String keyword) {
         List<Product> listOfProducts = repo.findByProductNameLikeIgnoreCase("%"+keyword+"%");
		
		List<ProductDTO> productDTO = listOfProducts.stream()
				.map(product -> modelMapper.map(product, ProductDTO.class))
						.collect(Collectors.toList());
		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productDTO);
		return productResponse;
	}

	@Override
	public ProductDTO UpdateProduct(Product product, Long productId) {
		Product getproduct = repo.findById(productId)
		.orElseThrow(()-> new ResourceNotFoundException("Product","productId",productId));
		
		getproduct.setProductName(product.getProductName());
		getproduct.setDescription(product.getDescription());
		getproduct.setPrice(product.getPrice());
		getproduct.setDiscount(product.getDiscount());
		getproduct.setQuantity(product.getQuantity());
		getproduct.setSpecialPrice(product.getSpecialPrice());
		
		Product savedProduct = repo.save(getproduct);
		
		
		return modelMapper.map(savedProduct, ProductDTO.class);
	}

	@Override
	public ProductDTO deleteProduct(Long productId) {
		
		Product getproduct = repo.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Product","productId",productId));
		repo.delete(getproduct);
		return modelMapper.map(getproduct, ProductDTO.class);
	}

}
