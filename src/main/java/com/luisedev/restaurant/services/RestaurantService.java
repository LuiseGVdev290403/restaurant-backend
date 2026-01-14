package com.luisedev.restaurant.services;

import com.google.zxing.qrcode.encoder.QRCode;
import com.luisedev.restaurant.dto.RestaurantCaractDto;
import com.luisedev.restaurant.dto.RestaurantDto;
import com.luisedev.restaurant.mapper.MapperRestaurant;
import com.luisedev.restaurant.model.Restaurant;
import com.luisedev.restaurant.model.RestaurantCaract;
import com.luisedev.restaurant.repository.RestaurantCaractRepository;
import com.luisedev.restaurant.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class RestaurantService implements IRestaurantService{

    @Autowired
    private QRCode qrCodeService;

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantCaractRepository restaurantCaractRepository;


    @Override
    public List<RestaurantDto> getAllRestaurant() {
        return restaurantRepository.findAll().stream().map(r -> {
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
    }


    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {

        return MapperRestaurant.restaurantDto(restaurantRepository.save(Restaurant.builder()
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
    }

    @Override
    public RestaurantDto editRestaurant(Long id, RestaurantDto restaurantDto) {
        try {
            Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with this id not exits"));
            restaurant.setDistrict(restaurantDto.getDistrict());
            restaurant.setRuc(restaurantDto.getRazonSocial());
            restaurant.setLogoPhoto(restaurantDto.getLogoPhoto());
            restaurant.setStreet(restaurantDto.getStreet());
            restaurant.getIdCaractRestaurant().setChairTable(restaurantDto.getCaractDto().getChairTable());
            restaurant.getIdCaractRestaurant().setFloorQty(restaurantDto.getCaractDto().getFloorQty());
            restaurant.getIdCaractRestaurant().setQr_code(restaurantDto.getCaractDto().getQrCode());
            restaurant.getIdCaractRestaurant().setTableQty(restaurantDto.getCaractDto().getTableQty());

            return MapperRestaurant.restaurantDto(restaurantRepository.save(restaurant));

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public String deleteRestaurant(Long id, RestaurantDto restaurantDto) {
        try {
            Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with this id not exits"));
            restaurantRepository.deleteById(id);
            return "That restaurant has been removed";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
