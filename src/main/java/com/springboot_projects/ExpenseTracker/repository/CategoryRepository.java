package com.springboot_projects.ExpenseTracker.repository;

import com.springboot_projects.ExpenseTracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Spring data JPA provides implementation
//    Provides CRUD methods to provide CRUD database operations on Category entity
//    Spring Data JPA provides transaction for all CRUD operations.
}
