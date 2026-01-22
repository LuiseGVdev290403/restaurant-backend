package com.luisedev.restaurant.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductTagDto {

    private Long id;
    private String name;
}
