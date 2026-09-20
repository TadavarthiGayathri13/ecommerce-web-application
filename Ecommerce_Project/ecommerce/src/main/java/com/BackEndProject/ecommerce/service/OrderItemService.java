package com.BackEndProject.ecommerce.service;

import com.BackEndProject.ecommerce.dto.OrderItemResponseDTO;
import com.BackEndProject.ecommerce.entity.Order;
import com.BackEndProject.ecommerce.entity.OrderItem;
import com.BackEndProject.ecommerce.entity.Product;
import com.BackEndProject.ecommerce.repository.OrderItemRepository;
import com.BackEndProject.ecommerce.repository.OrderRepository;
import com.BackEndProject.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemService(
            OrderItemRepository orderItemRepository,
            OrderRepository orderRepository,
            ProductRepository productRepository) {

        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderItemResponseDTO addOrderItem(
            Long orderId,
            Long productId,
            int quantity) {

        Order order = orderRepository
                .findById(orderId)
                .orElse(null);

        Product product = productRepository
                .findById(productId)
                .orElse(null);

        if (order == null || product == null) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);

        OrderItem savedItem =
                orderItemRepository.save(orderItem);

        return convertToDTO(savedItem);
    }

    public List<OrderItemResponseDTO> getAllOrderItems() {

        return orderItemRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    private OrderItemResponseDTO convertToDTO(OrderItem orderItem) {

        OrderItemResponseDTO dto = new OrderItemResponseDTO();

        dto.setId(orderItem.getId());
        dto.setOrderId(orderItem.getOrder().getId());
        dto.setProductId(orderItem.getProduct().getId());
        dto.setProductName(orderItem.getProduct().getName());
        dto.setQuantity(orderItem.getQuantity());

        return dto;
    }
}