package com.rakharafifa.miniproject.model.dto_get;

import lombok.Data;

@Data
public class AddressDto {
    private Long address_id;
    private String city;
    private String province;
    private UserDto userDto;
    private Long user_id;
}
