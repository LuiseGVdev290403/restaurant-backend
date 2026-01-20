package com.luisedev.restaurant.controller;


import com.luisedev.restaurant.controller.response.ApiResponse;
import com.luisedev.restaurant.dto.RestaurantDto;
import com.luisedev.restaurant.services.IRestaurantService;

import com.luisedev.restaurant.services.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {
    private IRestaurantService restaurantService;

    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<RestaurantDto>>> getAllRestaurant() {
        Response restaurants = restaurantService.getAllRestaurant();
        return ResponseEntity.status(restaurants.getStatus()).body(ApiResponse.<List<RestaurantDto>>builder()
                        .success(restaurants.isSuccess())
                        .message(restaurants.getData().get("message").toString())
                        .data((List<RestaurantDto>) restaurants.getData().get("body"))
                .build());
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<RestaurantDto>> saveRestaurant(@RequestBody RestaurantDto request) {
        Response response = restaurantService.createRestaurant(request);

        return ResponseEntity.status(response.getStatus()).body(ApiResponse.<RestaurantDto>builder()
                        .success(response.isSuccess())
                        .message(response.getData().get("message").toString())
                        .data((RestaurantDto) response.getData().get("body"))
                .build());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ApiResponse<RestaurantDto>> editRestaurant(@PathVariable Long id, @RequestBody RestaurantDto request) {
        Response response = restaurantService.editRestaurant(id, request);
        return  ResponseEntity.status(response.getStatus()).body(ApiResponse.<RestaurantDto>builder()
                        .success(response.isSuccess())
                        .message(response.getData().get("message").toString())
                        .data((RestaurantDto) response.getData().get("body"))
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> deletedRestaurant(@PathVariable Long id) {
        Response response = restaurantService.deleteRestaurant(id);
        return ResponseEntity.status(response.getStatus()).body(ApiResponse.<Map<String, Object>>
                builder()
                        .success(response.isSuccess())
                        .message(response.getData().get("message").toString())
                        .data((Map<String, Object>) response.getData().get("body"))
                .build());
    }
}
