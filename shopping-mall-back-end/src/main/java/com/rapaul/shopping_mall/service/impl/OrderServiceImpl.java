package com.rapaul.shopping_mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.rapaul.shopping_mall.dao.MemberDao;
import com.rapaul.shopping_mall.dao.OrderDao;
import com.rapaul.shopping_mall.dao.ProductDao;
import com.rapaul.shopping_mall.dto.BuyItem;
import com.rapaul.shopping_mall.dto.CreateOrderRequest;
import com.rapaul.shopping_mall.model.Member;
import com.rapaul.shopping_mall.model.Order;
import com.rapaul.shopping_mall.model.OrderDetail;
import com.rapaul.shopping_mall.model.Product;
import com.rapaul.shopping_mall.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService{
	
	private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	
	@Override
	public Order getOrderById(String orderId) {
		return orderDao.getOrderById(orderId);
	}

	@Transactional
	@Override
	public String createOrder(Integer memberId, CreateOrderRequest createOrderRequest) {
		// 檢查 member 是否存在
		Member member = memberDao.getMemberById(memberId);
		
		if(member == null) {
			log.warn("該 memberId {} 不存在", memberId);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		int totalPrice = 0;
		List<OrderDetail> orderDetailList = new ArrayList<>();
		
		for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
			Product product = productDao.getProductById(buyItem.getProductId());
			
			// 檢查 product 使否存在、庫存是否足夠
			if (product == null) {
				log.warn("商品 {} 不存在", buyItem.getProductId());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			} else if (product.getQuantity() < buyItem.getQuantity()) {
				log.warn("商品 {} 庫存數量不足，無法購買。剩餘庫存 {}，欲購買數量 {}",
						buyItem.getProductId(), product.getQuantity(), buyItem.getQuantity());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			
			// 扣除商品庫存
			productDao.updateQuantity(product.getProductId(), product.getQuantity() - buyItem.getQuantity());
			
			// 計算總價錢
			int itemPrice = buyItem.getQuantity() * product.getPrice();
			totalPrice = totalPrice + itemPrice;
			
			// 轉換 BuyItem to OrderItem
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProductId(buyItem.getProductId());
			orderDetail.setQuantity(buyItem.getQuantity());
			orderDetail.setStandPrice(product.getPrice());
			orderDetail.setItemPrice(itemPrice);
			
			orderDetailList.add(orderDetail);
			
		}
		
		// 創建訂單		
		String orderId = orderDao.createOrder(memberId, totalPrice);
		
		orderDao.createOrderDetails(orderId, orderDetailList);
		
		return orderId;
	}
	
	

}
