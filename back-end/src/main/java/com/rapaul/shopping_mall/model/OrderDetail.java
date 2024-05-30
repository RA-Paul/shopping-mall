package com.rapaul.shopping_mall.model;

import java.util.Date;

public class OrderDetail {
	
	private Integer orderItemSN;
	private String orderId;
	private String productId;
	private Integer quantity;
	private Integer standPrice;
	private Integer itemPrice;
	
	public Integer getOrderItemSN() {
		return orderItemSN;
	}
	public void setOrderItemSN(Integer orderItemSN) {
		this.orderItemSN = orderItemSN;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getStandPrice() {
		return standPrice;
	}
	public void setStandPrice(Integer standPrice) {
		this.standPrice = standPrice;
	}
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	
	
}
