package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.OrdersDto;

import java.util.List;

public class OderService implements IOrderService {
    @Override
    public List<OrdersDto> orderList(OrdersDto ordersDto) {
        return List.of();
    }

    @Override
    public OrdersDto createOrder(OrdersDto ordersDto) {
        return null;
    }

    @Override
    public OrdersDto editOrder(Long id, OrdersDto ordersDto) {
        return null;
    }
}
