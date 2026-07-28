package com.abhay.ordersystem.order_service.service.impl;

import com.abhay.ordersystem.order_service.dto.OrderRequest;
import com.abhay.ordersystem.order_service.dto.OrderResponse;
import com.abhay.ordersystem.order_service.entity.Order;
import com.abhay.ordersystem.order_service.mapper.OrderMapper;
import com.abhay.ordersystem.order_service.repository.OrderRepository;
import com.abhay.ordersystem.order_service.service.OrderService;
import com.abhay.ordersystem.order_service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        Order order = OrderMapper.toEntity(request);
        Order saved = orderRepository.save(order);
        return OrderMapper.toResponse(saved);
    }

    @Override
    public OrderResponse getOrderById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id : " + id));
        return OrderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {  return orderRepository.findAll()
            .stream()
            .map(OrderMapper::toResponse)
            .toList();

    }

    @Override
    public OrderResponse updateOrder(Long id, OrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id : " + id));
        order.setCustomerName(request.getCustomerName());
        order.setProductName(request.getProductName());
        order.setPrice(request.getPrice());
        order.setQuantity(request.getQuantity());
        Order updatedOrder = orderRepository.save(order);
        return OrderMapper.toResponse(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order not found with id : " + id);
        }

        orderRepository.deleteById(id);
    }
}