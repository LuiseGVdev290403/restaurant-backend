package com.luisedev.restaurant.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private List<ProductCategDto> productCategDtoList;
    private List<ProductFinalDto> productFinalDtoList;
}
