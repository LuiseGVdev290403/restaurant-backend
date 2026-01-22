package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.ProductCategDto;
import com.luisedev.restaurant.dto.ProductDto;
import com.luisedev.restaurant.dto.RestaurantDto;
import com.luisedev.restaurant.mapper.MapperProduct;
import com.luisedev.restaurant.mapper.MapperRestaurant;
import com.luisedev.restaurant.model.*;
import com.luisedev.restaurant.repository.ProductCategRepository;
import com.luisedev.restaurant.repository.ProductRepository;
import com.luisedev.restaurant.repository.ProductTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategRepository productCategRepository;

    @Autowired
    private ProductTagRepository productTagRepository;


    @Override
    public Response productList() {
        try {
            HashMap<String, Object> json = new HashMap<>();
            List<ProductDto> productDtos = productRepository.findAll().stream().map(MapperProduct::toDto).toList();
            json.put("message", "This is all product");
            json.put("body", productDtos);

            return Response.builder()
                    .success(true)
                    .status(200)
                    .data(json)
                    .build();

        } catch (Exception e) {
            HashMap<String, Object> json = new HashMap<>();
            json.put("message", "This is all product");
            json.put("body", "Have been a error " + e.getMessage() );
            return Response.builder()
                    .success(true)
                    .status(500)
                    .data(json)
                    .build();
        }

    }

    @Override
    public Response productCreate(ProductDto p) {
        try {
            Product product = Product.builder()
                    .name(p.getName())
                    .description(p.getDescription())
                    .build();

            if (!p.getProductCategDtoList().isEmpty()) {
                List<ProductCateg> productCategs = productCategRepository.findAllById(p.getProductCategDtoList().stream().map(ProductCategDto::getId).toList());
                product.setCategories(productCategs);
            }

            Product savedProduct = productRepository.save(product);

            if (!p.getProductFinalDtoList().isEmpty()) {
                List<ProductFinal> finals = p.getProductFinalDtoList().stream().map(f -> {

                    ProductTag tag = productTagRepository.findById(f.getProductTagDto().getId())
                            .orElseThrow(() -> new RuntimeException("Tag not found"));

                    return ProductFinal.builder()
                            .product(savedProduct)
                            .tags(tag)
                            .price(f.getPrice())
                            .build();

                }).toList();
            }

            HashMap<String, Object> json = new HashMap<>();
            json.put("message", "Product created correctly");
            json.put("body", MapperProduct.toDto(savedProduct));

            return Response.builder()
                    .status(201)
                    .success(true)
                    .data(json)
                    .build();

        } catch (Exception e) {
            HashMap<String, Object> json = new HashMap<>();
            json.put("message", "Have been a error in the moment created product" + e.getMessage());
            json.put("body", null);
            return Response.builder()
                    .status(201)
                    .success(true)
                    .data(json)
                    .build();
        }
    }

    @Override
    public Response productEdit(Long id, ProductDto p) {
        try {
            HashMap<String, Object> json = new HashMap<>();
            Optional<Product> product = productRepository.findById(id);
            if (product.isEmpty()) {
                json.put("message", "Product with this id not exits");
                json.put("body", null);

                return Response.builder()
                        .status(200)
                        .success(true)
                        .data(json)
                        .build();
            }
            product.get().setName(p.getName());
            product.get().setDescription(p.getName());
            Product savedProduct = productRepository.save(product.get());

            if (!p.getProductFinalDtoList().isEmpty()) {
                List<ProductFinal> finals = p.getProductFinalDtoList().stream().map(f -> {

                    ProductTag tag = productTagRepository.findById(f.getProductTagDto().getId())
                            .orElseThrow(() -> new RuntimeException("Tag not found"));

                    return ProductFinal.builder()
                            .product(savedProduct)
                            .tags(tag)
                            .price(f.getPrice())
                            .build();

                }).toList();
            }
            json.put("message", "Product edited correctly");
            json.put("body", MapperProduct.toDto(savedProduct));

            return Response.builder()
                    .status(200)
                    .success(true)
                    .data(json)
                    .build();
        } catch (Exception e) {

            HashMap<String, Object> json = new HashMap<>();
            json.put("message", "Have Been error");
            json.put("body", "Product with this id not exist: " + e.getMessage());

            return Response.builder()
                    .status(500)
                    .success(true)
                    .data(json)
                    .build();
        }

    }

    @Override
    public Response productDelete(Long id) {
        try {
            Map<String, Object> json = new HashMap<>();
            Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with this id not exits"));
            if ( product != null) {
                productRepository.deleteById(id);
                json.put("message", "Product has been deleted correctly");
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
