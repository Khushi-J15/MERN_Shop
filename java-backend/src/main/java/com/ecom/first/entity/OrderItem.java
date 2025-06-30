package com.ecom.first.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.ecom.first.enums.orderStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private int quantity;
	private BigDecimal price;
	private orderStatus status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;	
	
	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

	public Long getId() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setStatus(orderStatus status) {
		this.status = status;
	}

	
	
}
