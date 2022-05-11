package com.rakharafifa.miniproject.model.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long address_id;
    private String city;
    private String province;
    private Long post;
    private String detail;
}
