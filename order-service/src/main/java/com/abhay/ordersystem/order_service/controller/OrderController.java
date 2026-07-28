package com.abhay.ordersystem.order_service.controller;

import com.abhay.ordersystem.order_service.dto.OrderRequest;
import com.abhay.ordersystem.order_service.dto.OrderResponse;
import com.abhay.ordersystem.order_service.service.OrderService;
import com.abhay.ordersystem.order_service.service.impl.OrderServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }
    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
    @GetMapping
    public List<OrderResponse> getAllOrder(){
        return orderService.getAllOrders();
    }
    @PutMapping("/{id}")
    public OrderResponse updateOrder(
            @PathVariable Long id,
            @Valid @RequestBody OrderRequest request) {

        return orderService.updateOrder(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
