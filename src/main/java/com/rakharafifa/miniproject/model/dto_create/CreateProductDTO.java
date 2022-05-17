package com.rakharafifa.miniproject.model.dto_create;

import lombok.Data;

@Data
public class CreateProductDTO {
    private Long product_id;
    private String name;
    private String description;
    private Long price;
    private Long quantity;
}
