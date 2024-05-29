package com.rapaul.shopping_mall.dao;

import java.util.List;

import com.rapaul.shopping_mall.model.Product;

public interface ProductDao {

	List<Product> getProducts();
	
	Integer countProduct();
}
