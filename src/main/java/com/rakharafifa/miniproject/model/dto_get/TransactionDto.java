package com.rakharafifa.miniproject.model.dto_get;

import lombok.Data;

@Data
public class TransactionDto {
    private Long transaction_id;
    private Long price;
    private Long total_price;
    private ProductDto productDto;
    private UserDto userDto;
    private Long user_id;
    private Long product_id;
}
