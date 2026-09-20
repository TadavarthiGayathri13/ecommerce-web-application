package com.BackEndProject.ecommerce.repository;

import com.BackEndProject.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}