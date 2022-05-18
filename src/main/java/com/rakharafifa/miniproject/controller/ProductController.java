package com.rakharafifa.miniproject.controller;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.ProductDto;
import com.rakharafifa.miniproject.model.entity.Product;
import com.rakharafifa.miniproject.service.ProductService;

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
@RequestMapping("/miniproject/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<ProductDto>> getAllProductDto(){
        List<ProductDto> productDtos = productService.getAllProductDto();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") Long product_id){
        return new ResponseEntity<>(productService.getProductById(product_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProductDto(@RequestBody ProductDto productDto){
        productService.createProductDto(productDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("product_id") Long product_id, @RequestBody Product product){
        productService.updateProduct(product_id, product);
        return new ResponseEntity<>(productService.getProductById(product_id), HttpStatus.OK);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("product_id") Long product_id){
        productService.deleteProduct(product_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
