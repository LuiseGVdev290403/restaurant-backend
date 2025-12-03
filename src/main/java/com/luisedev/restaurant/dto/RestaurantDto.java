package com.luisedev.restaurant.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {

    private Long id;
    private String razonSocial;
    private String ruc;
    private String district;
    private String street;
    private String logoPhoto;

}
