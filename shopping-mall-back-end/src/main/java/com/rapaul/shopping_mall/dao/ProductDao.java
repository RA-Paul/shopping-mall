package com.rapaul.shopping_mall.dao;

import java.util.List;

import com.rapaul.shopping_mall.dto.ProductQueryParams;
import com.rapaul.shopping_mall.dto.ProductRequest;
import com.rapaul.shopping_mall.model.Product;

public interface ProductDao {

	List<Product> getProducts(ProductQueryParams productQueryParams);
	
	Product getProductById(String ProductId);
	
	String getProductMaxId();
	
	Integer countProduct();
	
	String createProduct(ProductRequest productRequest);
	
	void updateQuantity(String productId, Integer quantity);
	
}
