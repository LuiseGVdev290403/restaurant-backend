package com.luisedev.restaurant.controller;

import com.luisedev.restaurant.controller.response.ApiResponse;
import com.luisedev.restaurant.dto.ProductDto;
import com.luisedev.restaurant.services.IProductService;
import com.luisedev.restaurant.services.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private IProductService productService;

    public ProductController(IProductService pService) {
        this.productService = pService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getProduct() {
        Response response = productService.productList();

        return ResponseEntity.status(response.getStatus()).body(
                ApiResponse.<List<ProductDto>>builder()
                        .success(response.isSuccess())
                        .message(response.getData().get("message").toString())
                        .data((List<ProductDto>) response.getData().get("body"))
                        .build());
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<ProductDto>> saveProduct(@RequestBody ProductDto p) {
        Response response = productService.productCreate(p);
        return ResponseEntity.status(response.getStatus()).body(ApiResponse.<ProductDto>builder()
                        .message(response.getData().get("message").toString())
                        .data((ProductDto) response.getData().get("body"))
                        .success(response.isSuccess())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> editProduct(@PathVariable Long id, @RequestBody ProductDto p) {
        Response response = productService.productEdit(id, p);
        return ResponseEntity.status(response.getStatus()).body(ApiResponse.<ProductDto>builder()
                .message(response.getData().get("message").toString())
                .data((ProductDto) response.getData().get("body"))
                .success(response.isSuccess())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> eliminatedProduct(@PathVariable Long id) {
        Response response = productService.productDelete(id);
        return ResponseEntity.status(response.getStatus()).body(ApiResponse.<ProductDto>builder()
                .message(response.getData().get("message").toString())
                .data((ProductDto) response.getData().get("body"))
                .success(response.isSuccess())
                .build());
    }

}
