package com.rakharafifa.miniproject.model.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private Long transaction_id;
    private Long price;
    private Long total_price;
    private Long product_id;
    private Long user_id;
}
