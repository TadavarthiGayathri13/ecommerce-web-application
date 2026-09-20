package com.BackEndProject.ecommerce.service;

import com.BackEndProject.ecommerce.dto.CartItemResponseDTO;
import com.BackEndProject.ecommerce.entity.Cart;
import com.BackEndProject.ecommerce.entity.CartItem;
import com.BackEndProject.ecommerce.entity.Product;
import com.BackEndProject.ecommerce.repository.CartItemRepository;
import com.BackEndProject.ecommerce.repository.CartRepository;
import com.BackEndProject.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItemService(
            CartItemRepository cartItemRepository,
            CartRepository cartRepository,
            ProductRepository productRepository) {

        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // Add product to cart
    public CartItemResponseDTO addToCart(
            Long cartId,
            Long productId,
            int quantity) {

        Cart cart = cartRepository
                .findById(cartId)
                .orElse(null);

        Product product = productRepository
                .findById(productId)
                .orElse(null);

        if (cart == null || product == null) {
            return null;
        }

        CartItem cartItem = new CartItem();

        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        CartItem savedItem = cartItemRepository.save(cartItem);

        return convertToDTO(savedItem);
    }

    // Get all cart items
    public List<CartItemResponseDTO> getCartItems() {

        return cartItemRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Delete cart item
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private CartItemResponseDTO convertToDTO(CartItem cartItem) {

        CartItemResponseDTO dto = new CartItemResponseDTO();

        dto.setId(cartItem.getId());
        dto.setCartId(cartItem.getCart().getId());
        dto.setProductId(cartItem.getProduct().getId());
        dto.setProductName(cartItem.getProduct().getName());
        dto.setQuantity(cartItem.getQuantity());

        return dto;
    }
}