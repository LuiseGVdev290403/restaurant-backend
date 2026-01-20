package com.luisedev.restaurant.services;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Response {
    private int status;
    private boolean success;
    private Map<String, Object> data;
}
