package com.example.cicd1_catalog_service.controller;

import com.example.cicd1_catalog_service.dto.CreateProductRequest;
import com.example.cicd1_catalog_service.model.Product;
import com.example.cicd1_catalog_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    private final ProductService productService;

    public ProductController(ProductService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    // Controller method for JPQL query
    @GetMapping("/min-price")
    public List<Product> getByMinPrice(@RequestParam double minPrice){
        return productService.getByMinPrice(minPrice);
    }

    @GetMapping("/by-category")
    public List<Product> getByCategoryName(@RequestParam String categoryName){
        return productService.getByCategoryName(categoryName);
    }
}
