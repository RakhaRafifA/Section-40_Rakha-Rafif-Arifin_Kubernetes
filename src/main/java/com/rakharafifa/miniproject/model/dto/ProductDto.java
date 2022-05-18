package com.rakharafifa.miniproject.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long product_id;
    private String description;
    private String name;
    private Long price;
    private Long quantity;
}
