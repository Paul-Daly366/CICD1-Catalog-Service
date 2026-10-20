package com.example.cicd1_catalog_service.service;

import com.example.cicd1_catalog_service.dto.CreateProductRequest;
import com.example.cicd1_catalog_service.model.Category;
import com.example.cicd1_catalog_service.model.Product;
import com.example.cicd1_catalog_service.repository.CategoryRepository;
import com.example.cicd1_catalog_service.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product createProduct(CreateProductRequest request){
        if (request.categoryId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category id is required");
        }

        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category does not exist"));

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return repository.save(product);
    }

    public Product getById(Long id){
        return repository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
    }

    public List<Product> getByMinPrice(double minPrice){
        return repository.findByMinPrice(minPrice);
    }
}