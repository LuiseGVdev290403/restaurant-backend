package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> productList (ProductDto p);
    ProductDto productCreate (ProductDto p);
    ProductDto productEdit (Long id, ProductDto p);
    ProductDto productDelete (Long id);
}
