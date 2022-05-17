package com.rakharafifa.miniproject.model.dto_get;

import lombok.Data;

@Data
public class WalletDto {
    private Long wallet_id;
    private String name;
    private Long amount;
    private UserDto userDto;
    private Long user_id;
}
