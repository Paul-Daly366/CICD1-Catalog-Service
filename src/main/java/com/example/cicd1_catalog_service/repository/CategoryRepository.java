package com.example.cicd1_catalog_service.repository;

import com.example.cicd1_catalog_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
