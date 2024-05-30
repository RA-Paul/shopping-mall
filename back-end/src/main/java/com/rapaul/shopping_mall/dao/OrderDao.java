package com.rapaul.shopping_mall.dao;

import java.util.List;

import com.rapaul.shopping_mall.model.Order;
import com.rapaul.shopping_mall.model.OrderDetail;

public interface OrderDao {

	Order getOrderById(String orderId);
	
	List<Order> getOrderByMemberId(Integer memberId);
	
	List<OrderDetail> getOrderDetailByOrderId(String orderId);

	String createOrder(Integer memberId, Integer price);
	
	void createOrderDetails(String orderId, List<OrderDetail> orderDetailList);
	
}
