package com.rakharafifa.miniproject.model.dto_get;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long user_id;
    private String name;
    private String username;
}
