package com.rapaul.shopping_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rapaul.shopping_mall.dao.ProductDao;
import com.rapaul.shopping_mall.model.Product;
import com.rapaul.shopping_mall.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Override
	public Integer countProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

}
