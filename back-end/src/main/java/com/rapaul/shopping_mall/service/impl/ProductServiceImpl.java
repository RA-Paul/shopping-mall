package com.rapaul.shopping_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rapaul.shopping_mall.dao.ProductDao;
import com.rapaul.shopping_mall.dto.ProductQueryParams;
import com.rapaul.shopping_mall.dto.ProductRequest;
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
	public List<Product> getProducts(ProductQueryParams productQueryParams) {
		return productDao.getProducts(productQueryParams);
	}

	@Override
	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public String createProduct(ProductRequest productRequest) {

		String prefix = "P"; 
		String productId = "P001";
		String maxProductId = productDao.getProductMaxId();	
		if(maxProductId != null) {
		    int serialNumber = Integer.parseInt(maxProductId.substring(1)) + 1; // 提取流水号并加一
		    productId = String.format("%s%03d", prefix, serialNumber);	
		}
		return productDao.createProduct(productId, productRequest);
	}
	
	

}
