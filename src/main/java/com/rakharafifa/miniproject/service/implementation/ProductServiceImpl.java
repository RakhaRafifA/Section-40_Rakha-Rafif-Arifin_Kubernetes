package com.rakharafifa.miniproject.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.ProductDto;
import com.rakharafifa.miniproject.model.entity.ProductEntity;
import com.rakharafifa.miniproject.repository.ProductRepository;
import com.rakharafifa.miniproject.service.interfaces.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        List<ProductEntity> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public List<ProductDto> getAllProductDto() {
        List<ProductEntity> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        
        products.forEach(isi ->{
            ProductDto dto = new ProductDto();
            dto.setProduct_id(isi.getProduct_id());
            dto.setName(isi.getName());
            dto.setPrice(isi.getPrice());

            productDtos.add(dto);
        });
        return productDtos;
    }

    @Override
    public ProductEntity getProductById(Long product_id) {
        return productRepository.findById(product_id).get();
    }

    @Override
    public void createProduct(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long product_id, ProductEntity product) {
        ProductEntity product2 = productRepository.findById(product_id).get();
        System.out.println(product2.toString());
        product2.setName(product.getName());
        product2.setDescription(product.getDescription());
        product2.setPrice(product.getPrice());
        product2.setQuantity(product.getQuantity());
        productRepository.save(product2);
    }

    @Override
    public void deleteProduct(Long product_id) {
        productRepository.deleteById(product_id);
        
    }
}
