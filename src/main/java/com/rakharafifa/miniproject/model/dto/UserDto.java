package com.rakharafifa.miniproject.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long user_id;
    private String name;
    private String username;
    private String password;
    private Long address_id;
    private Long cart_id;
    private Long transaction_id;
    private Long wallet_id;
}
