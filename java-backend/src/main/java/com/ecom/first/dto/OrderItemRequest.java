package com.ecom.first.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
	
	private int productId;
	private int quantity;
	
	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
	
}
