package com.rapaul.shopping_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rapaul.shopping_mall.model.Product;
import com.rapaul.shopping_mall.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/api/products")
	List<Product> getProducts(){
		return productService.getProducts();
	}
	
}
