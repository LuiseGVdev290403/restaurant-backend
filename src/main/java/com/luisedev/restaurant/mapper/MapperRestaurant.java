package com.luisedev.restaurant.mapper;


import com.luisedev.restaurant.dto.*;
import com.luisedev.restaurant.model.OrderDetail;
import com.luisedev.restaurant.model.Orders;
import com.luisedev.restaurant.model.Product;
import com.luisedev.restaurant.model.Restaurant;


public class MapperRestaurant {

    public static RestaurantDto restaurantDto (Restaurant r) {
        if ( r == null) return null;
        return RestaurantDto.builder()
                .id(r.getId())
                .ruc(r.getRuc())
                .caractDto(RestaurantCaractDto.builder()
                        .id(r.getIdCaractRestaurant().getId())
                        .chairTable(r.getIdCaractRestaurant().getChairTable())
                        .qrCode(r.getIdCaractRestaurant().getQr_code())
                        .floorQty(r.getIdCaractRestaurant().getFloorQty())
                        .tableQty(r.getIdCaractRestaurant().getTableQty())
                        .build())
                .district(r.getDistrict())
                .logoPhoto(r.getLogoPhoto())
                .street(r.getStreet())
                .build();
    }


    // mapea productDto
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
                .build();
    }

    public static OrdersDto ordersDto (Orders o) {
        if (o == null) return null;
        return OrdersDto.builder()
                .id(o.getId())
                .dateOrder(o.getDateOrder())
                .stateDto(StateDto.builder()
                        .id(o.getState().getId())
                        .name(o.getState().getName())
                        .build())
                .timeAprox(o.getTimeAprox())
                .total(o.getTotal())
                .build();
    }
    public static OrderDetailDto orderDetail (OrderDetail orderDetail) {
        if (orderDetail == null) return null;
        return OrderDetailDto.builder()
                .id(orderDetail.getId())
                .ordersDto(ordersDto(orderDetail.getOrders()))
                .priceFinal(orderDetail.getPriceFinal())
                .priceUnit(orderDetail.getPriceUnit())
                .igv(orderDetail.getIgv())
                .qty(orderDetail.getQty())
                .productDto(toDto(orderDetail.getProductFinal().getProduct()))
                .build();
    }
}
