package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateProductDTO;
import com.rakharafifa.miniproject.model.dto_get.ProductDto;
import com.rakharafifa.miniproject.model.entity.Product;

public interface ProductService {
    List<Product> getAllProduct();
    List<ProductDto> getAllProductDto();
    Product getProductById(Long product_id);
    void createProductDto(CreateProductDTO createProductDTO);
    void updateProduct(Long product_id, Product product);
    void deleteProduct(Long product_id);
}
