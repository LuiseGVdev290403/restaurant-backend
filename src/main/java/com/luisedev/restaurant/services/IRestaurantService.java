package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.RestaurantDto;

public interface IRestaurantService {
    RestaurantDto createRestaurant (RestaurantDto restaurantDto);
    RestaurantDto editRestaurant (Long id, RestaurantDto restaurantDto);
    RestaurantDto deleteRestaurant (Long id, RestaurantDto restaurantDto);
}
