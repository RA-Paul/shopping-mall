package com.rapaul.shopping_mall.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rapaul.shopping_mall.dto.CreateOrderRequest;
import com.rapaul.shopping_mall.model.Order;
import com.rapaul.shopping_mall.model.OrderDetail;
import com.rapaul.shopping_mall.service.OrderService;

import jakarta.validation.Valid;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/api/members/{memberId}/orders")
	public ResponseEntity<List<Order>> getOrders(
			@PathVariable Integer memberId
	){
	
		List<Order> orderList = orderService.getOrderByMemberId(memberId);
		
		return ResponseEntity.status(HttpStatus.OK).body(orderList);
		
	}
	
	@GetMapping("/api/orders/{orderId}/details")
	public ResponseEntity<List<OrderDetail>> getOrderDetailByOrderId(
			@PathVariable String orderId
	){
	
		List<OrderDetail> orderDetailList = orderService.getOrderDetailByOrderId(orderId);
		
		return ResponseEntity.status(HttpStatus.OK).body(orderDetailList);
		
	}
	
	@PostMapping("/api/members/{memberId}/orders")
	public ResponseEntity<?> createOrder(@PathVariable Integer memberId, 
										@RequestBody @Valid CreateOrderRequest createOrderRequest){
		
		String orderId = orderService.createOrder(memberId, createOrderRequest);
		
		Order order = orderService.getOrderById(orderId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
		
	}
}
