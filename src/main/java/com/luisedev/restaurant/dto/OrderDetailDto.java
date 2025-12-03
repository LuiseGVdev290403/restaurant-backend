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
    private ProductFinalDto productFinalDto;
    private double priceUnit;
    private double priceFinal;
    private int qty;
    private double igv;
}
