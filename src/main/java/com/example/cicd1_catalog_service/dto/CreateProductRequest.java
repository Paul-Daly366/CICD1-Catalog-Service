package com.example.cicd1_catalog_service.dto;

import java.math.BigDecimal;

public record CreateProductRequest(String name,
                                   BigDecimal price,
                                   Long categoryId) {
}
