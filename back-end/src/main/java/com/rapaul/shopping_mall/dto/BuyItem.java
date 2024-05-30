package com.rapaul.shopping_mall.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BuyItem {
	
	@NotNull
	String productId;
	
	@NotNull
	@Min(value = 1)
	Integer quantity;
	
	
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
	
	
	
}
