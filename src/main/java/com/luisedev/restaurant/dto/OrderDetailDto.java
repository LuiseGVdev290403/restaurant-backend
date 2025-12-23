package com.luisedev.restaurant.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    private Long id;
    private OrdersDto ordersDto;
    private ProductDto productDto;
    private double priceUnit;
    private double priceFinal;
    private int qty;
    private double igv;
}
