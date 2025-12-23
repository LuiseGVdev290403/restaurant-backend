package com.luisedev.restaurant.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductFinalDto {

    private Long id;
    private ProductTagDto productTagDto;
    private double price;
}
