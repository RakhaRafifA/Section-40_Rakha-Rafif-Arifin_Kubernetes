package com.rakharafifa.miniproject.model.dto_get;

import lombok.Data;

@Data
public class CartDto {
    private Long cart_id;
    private Long product_id;
    private Long total_price;
    private Long quantity;
    private UserDto userDto;
    private Long user_id;
}
