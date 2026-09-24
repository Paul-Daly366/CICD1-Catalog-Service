package com.example.cicd1_catalog_service.service;

import com.example.cicd1_catalog_service.model.Product;
import com.example.cicd1_catalog_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private long nextId = 1;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product create(Product product){
        product.setId(null);
        return repository.save(product);
    }

}
