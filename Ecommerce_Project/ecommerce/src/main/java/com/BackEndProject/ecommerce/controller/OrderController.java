package com.BackEndProject.ecommerce.controller;
import java.util.List;
import com.BackEndProject.ecommerce.dto.OrderResponseDTO;
import com.BackEndProject.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/user/{userId}")
    public OrderResponseDTO createOrder(
            @PathVariable Long userId,
            @RequestParam double totalAmount) {

        return orderService.createOrder(
                userId,
                totalAmount
        );
    }

    @GetMapping("/{id}")
    public OrderResponseDTO getOrderById(
            @PathVariable Long id) {

        return orderService.getOrderById(id);
    }
    @GetMapping
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
}