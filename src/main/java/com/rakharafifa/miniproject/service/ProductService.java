package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.Product;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(Long product_id);
    Product createProduct(Product product);
    void updateProduct(Long product_id, Product product);
    void deleteProduct(Long product_id);
}
