package com.ecommerce.sb_ecom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.model.Product;

public interface Productrepositories extends JpaRepository<Product, Long> {

	List<Product> findByCategoryOrderByPriceAsc(Category categoryObj);

	List<Product> findByProductNameLikeIgnoreCase(String keyword);

}
