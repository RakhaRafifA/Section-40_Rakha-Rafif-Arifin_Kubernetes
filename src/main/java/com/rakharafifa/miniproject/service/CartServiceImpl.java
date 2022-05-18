package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.CartDto;
import com.rakharafifa.miniproject.model.dto.ProductDto;
import com.rakharafifa.miniproject.model.dto.UserDto;
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
        for(Cart cart : carts){
            CartDto cartDto = new CartDto();
            UserDto userDto = new UserDto();
            ProductDto productDto = new ProductDto();

            cartDto.setCart_id(cart.getCart_id());
            cartDto.setQuantity(cart.getQuantity());
            cartDto.setTotal_price(cart.getTotal_price());
            cartDto.setProduct_id(cart.getProduct().getProduct_id());
            cartDto.setUser_id(cart.getUser().getUser_id());

            userDto.setUser_id(cart.getUser().getUser_id());
            userDto.setName(cart.getUser().getName());
            userDto.setUsername(cart.getUser().getUsername());

            productDto.setProduct_id(cart.getProduct().getProduct_id());
            productDto.setName(cart.getProduct().getName());
            productDto.setPrice(cart.getProduct().getPrice());

            cartDtos.add(cartDto);
        }
        return cartDtos;
    }

    @Override
    public Cart getCartById(Long cart_id) {
        return cartRepository.findById(cart_id).get();
    }

    @Override
    public void createCartDto(CartDto cartDto) {
        Cart cart = new Cart();
        Product product = new Product();
        User user = new User();

        user.setUser_id(cartDto.getUser_id());
        product.setProduct_id(cartDto.getProduct_id());
        cart.setCart_id(cartDto.getCart_id());
        cart.setQuantity(cartDto.getQuantity());
        cart.setTotal_price(cartDto.getTotal_price());

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
