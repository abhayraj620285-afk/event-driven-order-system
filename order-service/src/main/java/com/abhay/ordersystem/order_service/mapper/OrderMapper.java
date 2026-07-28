package com.abhay.ordersystem.order_service.mapper;

import com.abhay.ordersystem.order_service.dto.OrderRequest;
import com.abhay.ordersystem.order_service.dto.OrderResponse;
import com.abhay.ordersystem.order_service.entity.Order;

public class OrderMapper {
    public static Order toEntity(OrderRequest request){
        return Order.builder()
                .customerName(request.getCustomerName())
                .productName(request.getProductName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .build();
    }
    public static OrderResponse toResponse(Order order){
        return OrderResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .productName(order.getProductName())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .build();

    }

}
