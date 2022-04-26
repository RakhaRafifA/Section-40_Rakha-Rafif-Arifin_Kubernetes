package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.Cart;

public interface CartService {
    List<Cart> getAllCart();
    Cart getCartById(Long cart_id);
    Cart createCart(Cart cart);
    void updateCart(Long cart_id, Cart cart);
    void deleteCart(Long cart_id);
}
