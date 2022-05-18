package com.rakharafifa.miniproject.model.dto_get;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private Long address_id;
    private String city;
    private String province;
    private UserDto userDto;
    private Long user_id;
}
