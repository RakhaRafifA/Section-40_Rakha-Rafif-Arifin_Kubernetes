package com.rakharafifa.miniproject.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalletDto {
    private Long wallet_id;
    private String name;
    private Long amount;
    private UserDto userDto;
    private Long user_id;
}
