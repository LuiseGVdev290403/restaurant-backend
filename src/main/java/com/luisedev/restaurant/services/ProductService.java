package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Override
    public List<ProductDto> productList(ProductDto p) {
        return List.of();
    }

    @Override
    public ProductDto productCreate(ProductDto p) {
        return null;
    }

    @Override
    public ProductDto productEdit(Long id, ProductDto p) {
        return null;
    }

    @Override
    public ProductDto productDelete(Long id) {
        return null;
    }
}
