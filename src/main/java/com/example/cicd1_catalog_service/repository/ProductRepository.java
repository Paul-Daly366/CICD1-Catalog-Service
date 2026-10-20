package com.example.cicd1_catalog_service.repository;

import com.example.cicd1_catalog_service.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice ORDER BY p.price ASC")
    List<Product> findByMinPrice(@Param("minPrice") double minPrice);
}
