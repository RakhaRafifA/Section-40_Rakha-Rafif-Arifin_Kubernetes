package com.rakharafifa.miniproject.model.dto_create;

import lombok.Data;

@Data
public class CreateWalletDTO {
    private Long wallet_id;
    private String name;
    private Long amount;
    private Long user_id;
}
