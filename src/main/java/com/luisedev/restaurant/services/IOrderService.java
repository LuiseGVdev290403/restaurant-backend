package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.OrdersDto;

import java.util.List;

public interface IOrderService {

    List<OrdersDto> orderList (OrdersDto ordersDto);
    OrdersDto createOrder (OrdersDto ordersDto);
    OrdersDto editOrder (Long id, OrdersDto ordersDto);
}
