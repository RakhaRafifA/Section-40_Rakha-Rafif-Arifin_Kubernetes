package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateCartDTO;
import com.rakharafifa.miniproject.model.dto_get.CartDto;
import com.rakharafifa.miniproject.model.entity.Cart;

public interface CartService {
    List<Cart> getAllCart();
    List<CartDto> getAllCartDto();
    Cart getCartById(Long cart_id);
    void createCartDto(CreateCartDTO createCartDTO);
    void updateCart(Long cart_id, Cart cart);
    void deleteCart(Long cart_id);
}
