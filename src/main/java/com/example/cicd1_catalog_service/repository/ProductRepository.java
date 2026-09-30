package com.example.cicd1_catalog_service.repository;

import com.example.cicd1_catalog_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
