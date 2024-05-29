package com.rapaul.shopping_mall.service;

import java.util.List;

import com.rapaul.shopping_mall.model.Product;

public interface ProductService {
	
	Integer countProduct();
	
	List<Product> getProducts();
	
}
