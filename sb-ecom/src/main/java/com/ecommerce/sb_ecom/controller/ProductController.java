package com.ecommerce.sb_ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.payload.ProductDTO;
import com.ecommerce.sb_ecom.payload.ProductResponse;
import com.ecommerce.sb_ecom.service.IProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private IProductService productService; 
	
	
	
	@PostMapping("/admin/categories/{categoryId}/Product")
	public ResponseEntity<ProductDTO> addProduct( @PathVariable(name="categoryId") Long categoryId, @RequestBody Product product)
	{
		System.out.println("call in controller");
		ProductDTO productDto = productService.addProduct(product,categoryId);
		return new ResponseEntity<ProductDTO>(productDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/public/products")
	public ResponseEntity<ProductResponse> getAllProducts() {
		ProductResponse products = productService.getAllProducts();
		return new ResponseEntity<ProductResponse>(products,HttpStatus.OK);
	}
	
	@GetMapping("/public/categories/{categoryId}/products")
	public ResponseEntity<ProductResponse> getProductByCategory(@PathVariable(name="categoryId") Long categoryId)
	{
		ProductResponse products = productService.getAllProductsByCategory(categoryId);
		return new ResponseEntity<ProductResponse>(products,HttpStatus.OK);
	}
	
	@GetMapping("/public/categories/keyword/{keyword}")
	public ResponseEntity<ProductResponse> getProductByCategory(@PathVariable(name="keyword") String keyword)
	{
		ProductResponse products = productService.searchProductsByKeyword(keyword);
		return new ResponseEntity<ProductResponse>(products,HttpStatus.FOUND);
	}
	
	@PutMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDTO> UpdayeProduct(@RequestBody Product product, @PathVariable(name="productId") Long productId)
	{
		ProductDTO products = productService.UpdateProduct(product,productId);
		return new ResponseEntity<ProductDTO>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productId)
	{
		ProductDTO products = productService.deleteProduct(productId);
		return new ResponseEntity<ProductDTO>(products,HttpStatus.OK);
	}

}
