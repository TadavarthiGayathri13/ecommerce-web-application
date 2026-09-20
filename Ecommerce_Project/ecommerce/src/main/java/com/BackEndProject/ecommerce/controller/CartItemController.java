package com.BackEndProject.ecommerce.controller;

import com.BackEndProject.ecommerce.dto.CartItemResponseDTO;
import com.BackEndProject.ecommerce.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    // Add product to cart
    @PostMapping("/cart/{cartId}/product/{productId}")
    public CartItemResponseDTO addToCart(
            @PathVariable Long cartId,
            @PathVariable Long productId,
            @RequestParam int quantity) {

        return cartItemService.addToCart(
                cartId,
                productId,
                quantity
        );
    }

    // Get all cart items
    @GetMapping
    public List<CartItemResponseDTO> getCartItems() {
        return cartItemService.getCartItems();
    }

    // Delete cart item
    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return "Cart item deleted successfully";
    }
}