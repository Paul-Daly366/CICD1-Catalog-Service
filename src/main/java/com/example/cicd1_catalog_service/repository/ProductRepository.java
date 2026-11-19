package com.example.cicd1_catalog_service.repository;

import com.example.cicd1_catalog_service.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // JPQL query to find all products above a price given by the user
    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice ORDER BY p.price ASC")
    List<Product> findByMinPrice(@Param("minPrice") double minPrice);

    // JPQL query to find all products in a category given by the user
    @Query("SELECT p FROM Product p JOIN p.category c WHERE LOWER(c.name) = LOWER(:categoryName) ORDER BY p.price ASC ")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);
}
