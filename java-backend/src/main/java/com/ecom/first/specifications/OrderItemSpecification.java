package com.ecom.first.specifications;


import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.ecom.first.enums.orderStatus;
import com.ecom.first.entity.OrderItem;
import com.ecom.first.entity.Order;

public class OrderItemSpecification {

    /**Specification to filter order items by status*/
    public static Specification<OrderItem> hasStatus(orderStatus status){
        return ((root, query, criteriaBuilder) ->
                status != null ? criteriaBuilder.equal(root.get("status"), status) : null);

    }

    /**Specification to filter order items by data range*/
    public static Specification<OrderItem> createdBetween(LocalDateTime startDate, LocalDateTime endDate){
        return ((root, query, criteriaBuilder) -> {
            if (startDate != null && endDate != null){
                return criteriaBuilder.between(root.get("createdAt"), startDate, endDate);
            } else if (startDate != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), startDate);
            } else if (endDate != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), endDate);
            }else{
                return null;
            }
        });
    }

    /** Generate specification to filter orderitems by item id*/
    public static Specification<OrderItem> hasItemId(Long itemId){
        return ((root, query, criteriaBuilder) ->
                itemId != null ? criteriaBuilder.equal(root.get("id"), itemId) : null);
    }
}