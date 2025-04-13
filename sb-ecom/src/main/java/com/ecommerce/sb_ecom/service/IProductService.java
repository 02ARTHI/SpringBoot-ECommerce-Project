package com.ecommerce.sb_ecom.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.payload.ProductDTO;
import com.ecommerce.sb_ecom.payload.ProductResponse;

public interface IProductService {

	ProductDTO addProduct(Product product, Long categoryId);

	ProductResponse getAllProducts();

	ProductResponse getAllProductsByCategory(Long categoryId);

	ProductResponse searchProductsByKeyword(String keyword);

	ProductDTO UpdateProduct(Product product, Long productId);

	ProductDTO deleteProduct(Long productId);

	ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;

}
