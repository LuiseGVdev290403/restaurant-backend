package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.RestaurantCaractDto;
import com.luisedev.restaurant.dto.RestaurantDto;
import com.luisedev.restaurant.mapper.MapperRestaurant;
import com.luisedev.restaurant.model.Restaurant;
import com.luisedev.restaurant.model.RestaurantCaract;
import com.luisedev.restaurant.repository.RestaurantCaractRepository;
import com.luisedev.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantService implements IRestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantCaractRepository restaurantCaractRepository;


    @Override
    public Response  getAllRestaurant() {
        try {
            HashMap<String, Object> json = new HashMap<>();

            List<RestaurantDto> restaurantDtoList = restaurantRepository.findAll().stream().map(r -> {
                return RestaurantDto.builder()
                        .id(r.getId())
                        .ruc(r.getRuc())
                        .street(r.getStreet())
                        .district(r.getDistrict())
                        .logoPhoto(r.getLogoPhoto())
                        .caractDto(RestaurantCaractDto.builder()
                                .id(r.getIdCaractRestaurant().getId())
                                .qrCode(r.getIdCaractRestaurant().getQr_code())
                                .tableQty(r.getIdCaractRestaurant().getTableQty())
                                .chairTable(r.getIdCaractRestaurant().getChairTable())
                                .floorQty(r.getIdCaractRestaurant().getFloorQty())
                                .build())
                        .build();
            }).toList();

            json.put("message", "All the restaurant actuality");
            json.put("body", restaurantDtoList);



            return Response.builder()
                    .status(200)
                    .success(true)
                    .data(json)
                    .build();
        } catch (Exception e) {
            HashMap<String, Object> json = new HashMap<>();

            json.put("message", "Error in the visualization the restaurant");
            json.put("body", e.getMessage());

            return Response.builder()
                    .status(500)
                    .success(true)
                    .data(json)
                    .build();
        }

    }


    @Override
    public Response createRestaurant(RestaurantDto restaurantDto) {
        try {
            HashMap<String, Object> json = new HashMap<>();
            RestaurantDto restaurant = MapperRestaurant.restaurantDto(restaurantRepository.save(Restaurant.builder()
                    .ruc(restaurantDto.getRuc())
                    .district(restaurantDto.getDistrict())
                    .street(restaurantDto.getLogoPhoto())
                    .razonsocial(restaurantDto.getRazonSocial())
                    .logoPhoto(restaurantDto.getLogoPhoto())
                    .idCaractRestaurant(restaurantCaractRepository.save(RestaurantCaract.builder()
                            .chairTable(restaurantDto.getCaractDto().getChairTable())
                            .qr_code(restaurantDto.getCaractDto().getQrCode())
                            .tableQty(restaurantDto.getCaractDto().getTableQty())
                            .floorQty(restaurantDto.getCaractDto().getFloorQty())
                            .build()))
                    .build()));
            json.put("message", "Restaurant created correctly");
            json.put("body", restaurant);

            return Response.builder()
                    .status(201)
                    .success(true)
                    .data(json)
                    .build();
        } catch (Exception e) {

            HashMap<String, Object> json = new HashMap<>();
            json.put("message", "Error in the moment created Restaurant");
            json.put("body", e.getMessage());

            return Response.builder()
                    .success(true)
                    .status(500)
                    .data(json)
                    .build();
        }

    }

    @Override
    public Response editRestaurant(Long id, RestaurantDto restaurantDto) {
        try {
            HashMap<String, Object> json = new HashMap<>();
            Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with this id not exits"));
            restaurant.setDistrict(restaurantDto.getDistrict());
            restaurant.setRuc(restaurantDto.getRazonSocial());
            restaurant.setLogoPhoto(restaurantDto.getLogoPhoto());
            restaurant.setStreet(restaurantDto.getStreet());
            restaurant.getIdCaractRestaurant().setChairTable(restaurantDto.getCaractDto().getChairTable());
            restaurant.getIdCaractRestaurant().setFloorQty(restaurantDto.getCaractDto().getFloorQty());
            restaurant.getIdCaractRestaurant().setQr_code(restaurantDto.getCaractDto().getQrCode());
            restaurant.getIdCaractRestaurant().setTableQty(restaurantDto.getCaractDto().getTableQty());

            restaurant = restaurantRepository.save(restaurant);

            json.put("message", "Restaurant has ben edited correctly");
            json.put("body", restaurant);


            return Response.builder()
                    .status(200)
                    .success(true)
                    .data(json)
                    .build();

        } catch (Exception e) {
            HashMap<String, Object> json = new HashMap<>();
            json.put("message", "Error in the moment the edited Restaurant");
            json.put("body", e.getMessage());

            return Response.builder()
                    .success(true)
                    .status(500)
                    .data(json)
                    .build();
        }

    }

    @Override
    public Response deleteRestaurant(Long id) {
        try {
            Map<String, Object> json = new HashMap<>();
            Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with this id not exits"));
            if (restaurant != null) {
                restaurantRepository.deleteById(id);
                json.put("message", "Restaurant has been deleted correctly");
                json.put("body", null);
                return  Response.builder()
                        .success(true)
                        .status(200)
                        .data(json)
                        .build();
            }
        } catch (Exception e) {
            Map<String, Object> json = new HashMap<>();
            json.put("message", e.getMessage());
            json.put("body", null);
            return Response.builder()
                    .status(204)
                    .success(true)
                    .data(json)
                    .build();
        }

        return null;
    }
}
