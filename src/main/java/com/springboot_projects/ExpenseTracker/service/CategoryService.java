package com.springboot_projects.ExpenseTracker.service;

import com.springboot_projects.ExpenseTracker.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long categoryId);

    List<CategoryDTO> getAllCategories();

    CategoryDTO patchCat(Long id, Map<String, Object> changes);
}
