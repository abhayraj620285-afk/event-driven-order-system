package com.abhay.ordersystem.order_service.dto;

import com.abhay.ordersystem.order_service.entity.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private Long id;

    private String customerName;

    private String productName;

    private Integer quantity;

    private BigDecimal price;

    private OrderStatus status;

    private LocalDateTime createdAt;
}