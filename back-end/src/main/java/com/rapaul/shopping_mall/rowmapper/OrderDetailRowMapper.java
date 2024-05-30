package com.rapaul.shopping_mall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rapaul.shopping_mall.model.OrderDetail;

public class OrderDetailRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderItemSN(rs.getInt("order_item_sn"));
		orderDetail.setOrderId(rs.getString("order_id"));
		orderDetail.setProductId(rs.getString("product_id"));
		orderDetail.setQuantity(rs.getInt("quantity"));
		orderDetail.setStandPrice(rs.getInt("stand_price"));
		orderDetail.setItemPrice(rs.getInt("item_price"));
		
		return orderDetail;
		
	}

}
