package com.rapaul.shopping_mall.service;

import java.util.List;

import com.rapaul.shopping_mall.dto.ProductQueryParams;
import com.rapaul.shopping_mall.dto.ProductRequest;
import com.rapaul.shopping_mall.model.Product;

public interface ProductService {
	
	Integer countProduct();
	
	List<Product> getProducts(ProductQueryParams productQueryParams);
	
	Product getProductById(String productId);
	
	String createProduct(ProductRequest productRequest);
	
}
