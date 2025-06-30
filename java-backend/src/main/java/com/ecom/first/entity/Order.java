package com.ecom.first.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private BigDecimal totalPrice;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItemList;
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	//Payment
}
