package com.rakharafifa.miniproject.model.dto_create;

import lombok.Data;

@Data
public class CreateAddressDTO {
    private Long address_id;
    private String city;
    private String province;
    private Long post;
    private String detail;
    private Long user_id;
}
