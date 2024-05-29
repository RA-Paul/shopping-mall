package com.rapaul.shopping_mall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rapaul.shopping_mall.model.Product;

public class ProductRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		product.setProductId(rs.getString("product_id"));
		product.setProductName(rs.getString("product_name"));
		product.setPrice(rs.getInt("price"));
		product.setQuantity(rs.getInt("quantity"));
		product.setCreatedDate(rs.getDate("created_date"));
		product.setLastModifiedDate(rs.getDate("last_modified_date"));
		
		return product;
		
	}
	
}
