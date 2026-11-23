package com.example.cicd1_catalog_service.controller;


import com.example.cicd1_catalog_service.model.Category;
import com.example.cicd1_catalog_service.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category){
        return service.create(category);
    }

    @GetMapping
    public List<Category> getAll(){
        return service.getAll();
    }
}
