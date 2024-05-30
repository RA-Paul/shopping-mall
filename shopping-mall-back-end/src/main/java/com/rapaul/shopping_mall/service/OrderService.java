package com.rapaul.shopping_mall.service;


import java.util.List;

import com.rapaul.shopping_mall.dto.CreateOrderRequest;
import com.rapaul.shopping_mall.model.Order;
import com.rapaul.shopping_mall.model.OrderDetail;

public interface OrderService {

	List<Order> getOrderByMemberId(Integer memberId);
	
	Order getOrderById(String orderId);
	
	List<OrderDetail> getOrderDetailByOrderId(String orderId);
	
	String createOrder(Integer memberId, CreateOrderRequest createOrderRequest);
	
}
