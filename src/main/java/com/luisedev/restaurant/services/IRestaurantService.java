package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.RestaurantDto;

import java.util.List;

public interface IRestaurantService {

    List<RestaurantDto> getAllRestaurant();
    RestaurantDto createRestaurant (RestaurantDto restaurantDto);
    RestaurantDto editRestaurant (Long id, RestaurantDto restaurantDto);
    String deleteRestaurant (Long id, RestaurantDto restaurantDto);
}
