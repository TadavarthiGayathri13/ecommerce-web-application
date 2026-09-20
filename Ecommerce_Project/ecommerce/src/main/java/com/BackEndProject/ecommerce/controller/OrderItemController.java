package com.BackEndProject.ecommerce.controller;

import com.BackEndProject.ecommerce.dto.OrderItemResponseDTO;
import com.BackEndProject.ecommerce.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Add product to order
    @PostMapping("/order/{orderId}/product/{productId}")
    public OrderItemResponseDTO addOrderItem(
            @PathVariable Long orderId,
            @PathVariable Long productId,
            @RequestParam int quantity) {

        return orderItemService.addOrderItem(
                orderId,
                productId,
                quantity
        );
    }

    // Get all order items
    @GetMapping
    public List<OrderItemResponseDTO> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    // Delete order item
    @DeleteMapping("/{id}")
    public String deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return "Order item deleted successfully";
    }
}