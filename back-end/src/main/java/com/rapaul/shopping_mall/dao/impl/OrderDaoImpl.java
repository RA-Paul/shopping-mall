package com.rapaul.shopping_mall.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.rapaul.shopping_mall.dao.OrderDao;
import com.rapaul.shopping_mall.model.Order;
import com.rapaul.shopping_mall.model.OrderDetail;
import com.rapaul.shopping_mall.rowmapper.OrderRowMapper;
import com.rapaul.shopping_mall.rowmapper.OrderDetailRowMapper;


@Component
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public Order getOrderById(String orderId) {

		String sql = "CALL GetOrderById(:orderId);";
		
		Map<String, Object> map = new HashMap<>();
		map.put("orderId", orderId);
		
		List<Order> orderList = namedParameterJdbcTemplate.query(sql, map, new OrderRowMapper());
		
		if(orderList.size() > 0) {
			return orderList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<Order> getOrderByMemberId(Integer memberId) {

		String sql = "CALL GetOrderByMemberId(:memberId);";
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		
		List<Order> orderList = namedParameterJdbcTemplate.query(sql, map, new OrderRowMapper());
		
		return orderList;
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderId(String orderId) {

		String sql = "CALL GetOrderDetailByOrderId(:orderId);";
		
		Map<String, Object> map = new HashMap<>();
		map.put("orderId", orderId);
		
		List<OrderDetail> orderDetailList = namedParameterJdbcTemplate.query(sql, map, new OrderDetailRowMapper());
		
		return orderDetailList;
	}

	@Override
	public String createOrder(Integer memberId, Integer price) {

		String sql = "CALL CreateOrder(:orderId, :memberId , :price , :payStatus , :createdDate , :lastModifiedDate);";
		
		Map<String, Object> map = new HashMap<>();
		
		Date now = new Date();
		
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderId = "Ms" + formatter.format(now);

		map.put("orderId", orderId);
		map.put("memberId", memberId);
		map.put("price", price);
		map.put("payStatus", 0);
		map.put("createdDate", now);
		map.put("lastModifiedDate", now);
		
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));
		
		return orderId;
	}

	@Override
	public void createOrderDetails(String orderId, List<OrderDetail> orderDetailList) {
		
		String sql = "CALL CreateOrderDetails(:orderId , :productId , :quantity , :standPrice , :itemPrice);";
		
		MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[orderDetailList.size()];
		
		for(int i = 0; i < orderDetailList.size(); i++) {
			OrderDetail orderDetail = orderDetailList.get(i);
			
			parameterSources[i] = new MapSqlParameterSource();
			parameterSources[i].addValue("orderId", orderId);
			parameterSources[i].addValue("productId", orderDetail.getProductId());
			parameterSources[i].addValue("quantity", orderDetail.getQuantity());
			parameterSources[i].addValue("standPrice", orderDetail.getStandPrice());	
			parameterSources[i].addValue("itemPrice", orderDetail.getItemPrice());		
		}
		
		namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);
		
	}

}
