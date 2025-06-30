package com.ecom.first.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.ecom.first.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@Column(unique = true)
	@NotBlank(message = "Email is required")
	private String email;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	@Column(name = "phone_number")
	@NotBlank(message = "Phone number is required")
	private String phoneNumber;
	
	private UserRole role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderItem> orderItemList;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	public Long getId() { return id; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public UserRole getRole() { return role; }
    public String getName() { return name; }
    
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getPassword() {
		return password;
	}
	public Address getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
    
}
