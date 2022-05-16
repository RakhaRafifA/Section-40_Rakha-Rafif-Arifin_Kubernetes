package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.CartDto;
import com.rakharafifa.miniproject.model.entity.Cart;
import com.rakharafifa.miniproject.model.entity.Product;
import com.rakharafifa.miniproject.model.entity.User;
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
    public List<CartDto> getAllCartDto() {
        List<Cart> carts = cartRepository.findAll();
        List<CartDto> cartDtos = new ArrayList<>();
        
        carts.forEach(isi ->{
            CartDto dto = new CartDto();
            dto.setCart_id(isi.getCart_id());
            dto.setQuantity(isi.getQuantity());
            dto.setTotal_price(isi.getTotal_price());

            cartDtos.add(dto);
        });
        return cartDtos;
    }

    @Override
    public Cart getCartById(Long cart_id) {
        return cartRepository.findById(cart_id).get();
    }

    @Override
    public void createCartDto(CartDto cartDtos) {
        Cart cart = new Cart();
        Product product = new Product();
        User user = new User();

        user.setUser_id(cartDtos.getUser_id());
        product.setProduct_id(cartDtos.getProduct_id());
        cart.setCart_id(cartDtos.getCart_id());
        cart.setQuantity(cartDtos.getQuantity());
        cart.setTotal_price(cartDtos.getTotal_price());

        cartRepository.save(cart);
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
