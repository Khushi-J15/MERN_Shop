package com.ecom.first.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.ecom.first.entity.OrderItem;
import com.ecom.first.entity.Payment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
	
	private BigDecimal totalPrice;
	private List<OrderItemRequest> items;
	private Payment paymentInfo;
	
	public Object getTotalPrice() {
		// TODO Auto-generated method stub
		return totalPrice;
	}

	public List<OrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}

	
	
}
