package com.luisedev.restaurant.mapper;

import com.luisedev.restaurant.dto.ProductCategDto;
import com.luisedev.restaurant.dto.ProductDto;
import com.luisedev.restaurant.dto.ProductFinalDto;
import com.luisedev.restaurant.dto.ProductTagDto;
import com.luisedev.restaurant.model.Product;
import lombok.Builder;

@Builder
public class MapperProduct {

    // getProduct
    public static ProductDto toDto(Product p) {
        if (p == null) return null;

        return ProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .productCategDtoList(p.getCategories().stream().map(pg -> {
                    return ProductCategDto.builder()
                            .id(pg.getId())
                            .name(pg.getName())
                            .build();
                }).toList())
                .productFinalDtoList(p.getProducts().stream().map(productFinal -> {
                    return ProductFinalDto.builder()
                            .id(productFinal.getId())
                            .price(productFinal.getPrice())
                            .productTagDto(ProductTagDto.builder()
                                    .id(productFinal.getTags().getId())
                                    .name(productFinal.getTags().getName())
                                    .build())
                            .build();
                }).toList())
                .productTagDtoList(p.getProducts() .stream().map( productTag -> {
                    return ProductTagDto.builder()
                            .id(productTag.getTags().getId())
                            .name(productTag.getTags().getName())
                            .build();
                }).toList())
                .build();
    }

}
