package com.rapaul.shopping_mall.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.rapaul.shopping_mall.dao.ProductDao;
import com.rapaul.shopping_mall.model.Product;
import com.rapaul.shopping_mall.rowmapper.ProductRowMapper;

@Component
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Product> getProducts() {
		
		String sql = "SELECT product_id, product_name, price, quantity, "
				+ "created_date, last_modified_date FROM product ;";
		
		Map<String, Object> map = new HashMap<>();
		
		List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
		
		return productList;
	}

	@Override
	public Integer countProduct() {
		String sql = "SELECT COUNT(*) FROM product";
		
		Map<String, Object> map = new HashMap<>();
		
		Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
		
		return total;
	}
	
	

}
