package com.luisedev.restaurant.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantCaractDto {
    private Long id;



    private int floorQty;
    private int tableQty;
    private int chairTable;
    private String qrCode;
}
