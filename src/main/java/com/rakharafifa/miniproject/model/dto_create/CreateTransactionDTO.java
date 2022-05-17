package com.rakharafifa.miniproject.model.dto_create;

import lombok.Data;

@Data
public class CreateTransactionDTO {
    private Long transaction_id;
    private Long total_price;
    private Long user_id;
    private Long product_id;
    private Long price;
}
