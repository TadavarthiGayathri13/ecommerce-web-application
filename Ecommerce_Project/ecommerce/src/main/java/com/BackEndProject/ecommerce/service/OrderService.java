package com.BackEndProject.ecommerce.service;
import java.util.List;
import com.BackEndProject.ecommerce.dto.OrderResponseDTO;
import com.BackEndProject.ecommerce.entity.Order;
import com.BackEndProject.ecommerce.entity.User;
import com.BackEndProject.ecommerce.repository.OrderRepository;
import com.BackEndProject.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public OrderResponseDTO createOrder(
            Long userId,
            double totalAmount) {

        User user = userRepository
                .findById(userId)
                .orElse(null);

        if (user == null) {
            return null;
        }

        Order order = new Order();

        order.setUser(user);
        order.setTotalAmount(totalAmount);
        order.setStatus("PLACED");

        Order savedOrder =
                orderRepository.save(order);

        return convertToDTO(savedOrder);
    }

    public OrderResponseDTO getOrderById(Long id) {

        Order order = orderRepository
                .findById(id)
                .orElse(null);

        if (order == null) {
            return null;
        }

        return convertToDTO(order);
    }

    private OrderResponseDTO convertToDTO(Order order) {

        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());

        return dto;
    }
    public List<OrderResponseDTO> getAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
}