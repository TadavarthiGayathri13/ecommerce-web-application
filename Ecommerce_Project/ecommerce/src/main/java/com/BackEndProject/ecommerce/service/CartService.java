package com.BackEndProject.ecommerce.service;

import com.BackEndProject.ecommerce.entity.Cart;
import com.BackEndProject.ecommerce.entity.User;
import com.BackEndProject.ecommerce.repository.CartRepository;
import com.BackEndProject.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository,
                       UserRepository userRepository) {

        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    // Create cart for a user
    public Cart createCart(Long userId) {

        User user = userRepository
                .findById(userId)
                .orElse(null);

        if (user == null) {
            return null;
        }

        Cart cart = new Cart();

        cart.setUser(user);

        return cartRepository.save(cart);
    }

    // Get cart by cart ID
    public Cart getCartById(Long id) {

        return cartRepository
                .findById(id)
                .orElse(null);
    }
}