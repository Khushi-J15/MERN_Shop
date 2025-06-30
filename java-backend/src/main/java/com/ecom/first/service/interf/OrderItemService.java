package com.ecom.first.service.interf;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;

import com.ecom.first.dto.OrderRequest;
import com.ecom.first.dto.Response;
import com.ecom.first.enums.orderStatus;

public interface OrderItemService {
	  	Response placeOrder(OrderRequest orderRequest);
	    Response updateOrderItemStatus(Long orderItemId, String status);
	    Response filterOrderItems(orderStatus status, LocalDateTime startDate, LocalDateTime endDate, Long itemId, Pageable pageable);
}
