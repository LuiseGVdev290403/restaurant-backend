package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.ProductDto;

import java.util.List;

public interface IProductService {
    Response productList ();
    Response productCreate (ProductDto p);
    Response productEdit (Long id, ProductDto p);
    Response productDelete (Long id);
}
