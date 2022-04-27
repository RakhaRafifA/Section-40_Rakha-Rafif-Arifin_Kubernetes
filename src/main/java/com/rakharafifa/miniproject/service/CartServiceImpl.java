package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.entity.Cart;
import com.rakharafifa.miniproject.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> getAllCart() {
        List<Cart> carts = new ArrayList<>();
        cartRepository.findAll().forEach(carts::add);
        return carts;
    }

    @Override
    public Cart getCartById(Long cart_id) {
        return cartRepository.findById(cart_id).get();
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void updateCart(Long cart_id, Cart cart) {
        Cart cart2 = cartRepository.findById(cart_id).get();
        System.out.println(cart2.toString());
        cart2.setQuantity(cart.getQuantity());
        cart2.setTotal_price(cart.getTotal_price());
        cartRepository.save(cart2);
    }

    @Override
    public void deleteCart(Long cart_id) {
        cartRepository.deleteById(cart_id);
        
    }
}
