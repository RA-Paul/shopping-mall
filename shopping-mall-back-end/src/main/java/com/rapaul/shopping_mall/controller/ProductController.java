package com.rapaul.shopping_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rapaul.shopping_mall.dto.ProductQueryParams;
import com.rapaul.shopping_mall.dto.ProductRequest;
import com.rapaul.shopping_mall.model.Product;
import com.rapaul.shopping_mall.service.ProductService;

import jakarta.validation.Valid;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/api/products")
	List<Product> getProducts(
			@RequestParam(defaultValue = "false") Boolean inStock
	){
		ProductQueryParams productQueryParams = new ProductQueryParams();
		productQueryParams.setInStock(inStock);
		
		return productService.getProducts(productQueryParams);
	}
	
	@PostMapping("/api/products")
	Product createProduct(@RequestBody @Valid ProductRequest productRequest){
		String productId = productService.createProduct(productRequest);
		Product product = productService.getProductById(productId);
		
		return product;
	}
	
}
