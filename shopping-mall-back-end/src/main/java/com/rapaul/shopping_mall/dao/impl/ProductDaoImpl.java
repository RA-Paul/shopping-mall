package com.rapaul.shopping_mall.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.rapaul.shopping_mall.dao.ProductDao;
import com.rapaul.shopping_mall.dto.ProductQueryParams;
import com.rapaul.shopping_mall.dto.ProductRequest;
import com.rapaul.shopping_mall.model.Product;
import com.rapaul.shopping_mall.rowmapper.ProductRowMapper;
import com.rapaul.shopping_mall.service.impl.UserServiceImpl;

@Component
public class ProductDaoImpl implements ProductDao{

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Product> getProducts(ProductQueryParams productQueryParams) {
		
		String sql = "SELECT product_id, product_name, price, quantity, "
				+ "created_date, last_modified_date FROM product WHERE 1=1 ";
		
		Map<String, Object> map = new HashMap<>();
		
		if(productQueryParams.getInStock()) {
			sql = sql + " AND quantity > 0";
		}
		
		List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
		
		return productList;
	}
	

	@Override
	public Product getProductById(String ProductId) {
		
		String sql = "SELECT product_id, product_name, price, quantity, "
				+ "created_date, last_modified_date FROM product WHERE product_id = :productId";
		
		Map<String, Object> map = new HashMap<>();
		map.put("productId", ProductId);
		
		List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
		
		if(productList.size() > 0) {
			return productList.get(0);
		}else {
			return null;
		}
	}
	

	@Override
	public String getProductMaxId() {
		String sql = "SELECT MAX(product_id) FROM product";
		
		Map<String, Object> map = new HashMap<>();
		
		String productId = namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
		
		return productId;
	}


	@Override
	public Integer countProduct() {
		String sql = "SELECT COUNT(*) FROM product";
		
		Map<String, Object> map = new HashMap<>();
		
		Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
		
		return total;
	}


	@Override
	public String createProduct(ProductRequest productRequest) {
		String sql = "INSERT product(product_id, product_name, price, quantity, created_date, last_modified_date)"
				+ " VALUES ( :productId , :productName , :price , :quantity, :createdDate , :lastModifiedDate );";
		
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productRequest.getProductId());
		map.put("productName", productRequest.getProductName());
		map.put("productName", productRequest.getProductName());
		map.put("price", productRequest.getPrice());
		map.put("quantity", productRequest.getQuantity());
		
		Date now = new Date();
		map.put("createdDate", now);
		map.put("lastModifiedDate", now);

		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));
		
		return productRequest.getProductId();
		
	}


	@Override
	public void updateQuantity(String productId, Integer quantity) {
		
		String sql = "UPDATE product SET quantity = :quantity, last_modified_date = :lastModifiedDate"
				+ " WHERE product_id = :productId";
		
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("quantity", quantity);
		map.put("lastModifiedDate", new Date());
		
		namedParameterJdbcTemplate.update(sql, map);
		
	}
	
	
	
	

}
