package com.springboot_projects.ExpenseTracker.service;

import com.springboot_projects.ExpenseTracker.dto.CategoryDTO;
import com.springboot_projects.ExpenseTracker.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long categoryId);

    List<CategoryDTO> getAllCategories();

    CategoryDTO patchCat(Long id, Map<String, Object> changes);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long id);
}
