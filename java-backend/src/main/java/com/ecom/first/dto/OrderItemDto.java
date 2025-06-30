package com.ecom.first.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
	
	private Long id;
	private int quantity;
	private BigDecimal price;
	private String status;
	private UserDto user;
	private ProductDto product;
	private LocalDateTime createdAt;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
}


