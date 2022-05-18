package com.rakharafifa.miniproject.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDto {
    private Long cart_id;
    private Long total_price;
    private Long quantity;
    private Long user_id;
    private UserDto userDto;
    private Long product_id;
    private ProductDto productDto;
}
