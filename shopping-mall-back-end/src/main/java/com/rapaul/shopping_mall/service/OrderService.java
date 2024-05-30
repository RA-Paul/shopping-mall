package com.rapaul.shopping_mall.service;


import com.rapaul.shopping_mall.dto.CreateOrderRequest;
import com.rapaul.shopping_mall.model.Order;

public interface OrderService {
		
	Order getOrderById(String orderId);
	
	String createOrder(Integer memberId, CreateOrderRequest createOrderRequest);
	
}
