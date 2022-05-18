package com.rakharafifa.miniproject.service.interfaces;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.ProductDto;
import com.rakharafifa.miniproject.model.entity.ProductEntity;

public interface ProductService {
    List<ProductEntity> getAllProduct();
    List<ProductDto> getAllProductDto();
    ProductEntity getProductById(Long product_id);
    void createProduct(ProductEntity product);
    void updateProduct(Long product_id, ProductEntity product);
    void deleteProduct(Long product_id);
}
