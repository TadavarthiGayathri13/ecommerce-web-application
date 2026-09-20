package com.BackEndProject.ecommerce.controller;

import com.BackEndProject.ecommerce.entity.Cart;
import com.BackEndProject.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Create cart for a user
    @PostMapping("/user/{userId}")
    public Cart createCart(@PathVariable Long userId) {

        return cartService.createCart(userId);
    }

    // Get cart by ID
    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {

        return cartService.getCartById(id);
    }
}