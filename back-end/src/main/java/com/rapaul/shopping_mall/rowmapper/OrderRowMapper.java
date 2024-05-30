package com.rapaul.shopping_mall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rapaul.shopping_mall.model.Order;

public class OrderRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order order = new Order();
		order.setOrderId(rs.getString("order_id"));
		order.setMemberId(rs.getInt("member_id"));
		order.setPrice(rs.getInt("price"));
		order.setPayStatus(rs.getInt("pay_status"));
		order.setCreatedDate(rs.getDate("created_date"));
		order.setLastModifiedDate(rs.getDate("last_modified_date"));
		
		return order;
		
	}

}
