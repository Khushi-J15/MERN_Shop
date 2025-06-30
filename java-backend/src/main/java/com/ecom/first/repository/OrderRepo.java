package com.ecom.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.first.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
