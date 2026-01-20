package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.RestaurantDto;
import com.luisedev.restaurant.model.Restaurant;

import java.util.List;

public interface IRestaurantService {

    Response getAllRestaurant();
    Response createRestaurant (RestaurantDto restaurantDto);
    Response editRestaurant (Long id, RestaurantDto restaurantDto);
    Response deleteRestaurant (Long id);
}
