package com.ecom.first.dto;

import java.util.List;

import com.ecom.first.entity.OrderItem;
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
public class UserDto {
	
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private String role;
	
	private List<OrderItemDto> orderItemList;
	private AddressDto address;
	
	public void setId(Long id) { this.id = id; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
    public void setName(String name) { this.name = name; }
    public void setAddress(AddressDto address) { this.address = address; }
	
    public void setOrderItemList(List<OrderItemDto> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public List<OrderItemDto> getOrderItemList() {
		return orderItemList;
	}
	public AddressDto getAddress() {
		return address;
	}
}
