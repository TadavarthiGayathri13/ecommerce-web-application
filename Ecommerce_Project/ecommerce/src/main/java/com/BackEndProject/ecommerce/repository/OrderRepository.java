package com.BackEndProject.ecommerce.repository;

import com.BackEndProject.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}