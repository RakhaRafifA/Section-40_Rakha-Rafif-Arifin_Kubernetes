package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.ProductDto;
import com.rakharafifa.miniproject.model.entity.Product;
import com.rakharafifa.miniproject.repository.ProductRepository;

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
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public List<ProductDto> getAllProductDto() {
        List<Product> products = productRepository.findAll();
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
    public Product getProductById(Long product_id) {
        return productRepository.findById(product_id).get();
    }

    @Override
    public void createProductDto(ProductDto productDtos) {
        Product product = new Product();

        product.setProduct_id(productDtos.getProduct_id());
        product.setName(productDtos.getName());
        product.setPrice(productDtos.getPrice());
        product.setQuantity(productDtos.getQuantity());
        product.setDescription(productDtos.getDescription());

        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long product_id, Product product) {
        Product product2 = productRepository.findById(product_id).get();
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
