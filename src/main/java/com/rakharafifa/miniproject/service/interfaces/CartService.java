package com.rakharafifa.miniproject.service.interfaces;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.CartDto;
import com.rakharafifa.miniproject.model.entity.CartEntity;

public interface CartService {
    List<CartEntity> getAllCart();
    List<CartDto> getAllCartDto();
    CartEntity getCartById(Long cart_id);
    void createCart(CartEntity cart);
    void updateCart(Long cart_id, CartEntity cart);
    void deleteCart(Long cart_id);
}
