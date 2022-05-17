package com.rakharafifa.miniproject.model.dto_create;

import lombok.Data;

@Data
public class CreateCartDTO {
    private Long cart_id;
    private Long total_price;
    private Long product_id;
    private Long quantity;
    private Long user_id;
}
