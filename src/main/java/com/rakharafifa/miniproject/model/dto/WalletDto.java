package com.rakharafifa.miniproject.model.dto;

import lombok.Data;

@Data
public class WalletDto {
    private Long wallet_id;
    private String name;
    private Long amount;
    private Long top_up;
    private Long user_id;
}
