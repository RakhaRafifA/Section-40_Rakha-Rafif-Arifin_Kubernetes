package com.rakharafifa.miniproject.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.CartDto;
import com.rakharafifa.miniproject.model.entity.CartEntity;

import com.rakharafifa.miniproject.repository.CartRepository;
import com.rakharafifa.miniproject.service.interfaces.CartService;

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
    public List<CartEntity> getAllCart() {
        List<CartEntity> carts = new ArrayList<>();
        cartRepository.findAll().forEach(carts::add);
        return carts;
    }

    @Override
    public List<CartDto> getAllCartDto() {
        List<CartEntity> carts = cartRepository.findAll();
        List<CartDto> cartDtos = new ArrayList<>();
        
        carts.forEach(isi ->{
            CartDto dto = new CartDto();
            dto.setCart_id(isi.getCart_id());
            dto.setTotal_price(isi.getTotal_price());
            dto.setQuantity(isi.getQuantity());
            
            cartDtos.add(dto);
        });
        return cartDtos;
    }

    @Override
    public CartEntity getCartById(Long cart_id) {
        return cartRepository.findById(cart_id).get();
    }

    @Override
    public void createCart(CartEntity cart) {
        cartRepository.save(cart);
    }

    @Override
    public void updateCart(Long cart_id, CartEntity cart) {
        CartEntity cart2 = cartRepository.findById(cart_id).get();
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
