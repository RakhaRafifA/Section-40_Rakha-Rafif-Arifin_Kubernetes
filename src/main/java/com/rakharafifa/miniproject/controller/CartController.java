package com.rakharafifa.miniproject.controller;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.Cart;
import com.rakharafifa.miniproject.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniproject/cart")
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCart(){
        List<Cart> carts = cartService.getAllCart();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/{cart_id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("cart_id") Long cart_id){
        return new ResponseEntity<>(cartService.getCartById(cart_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        Cart cart2 = cartService.createCart(cart);
        return new ResponseEntity<>(cart2, HttpStatus.OK);
    }

    @PutMapping("/{cart_id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("/cart_id") Long cart_id, @RequestBody Cart cart){
        cartService.updateCart(cart_id, cart);
        return new ResponseEntity<>(cartService.getCartById(cart_id), HttpStatus.OK);
    }

    @DeleteMapping("/{cart_id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable("/cart_id") Long cart_id){
        cartService.deleteCart(cart_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
