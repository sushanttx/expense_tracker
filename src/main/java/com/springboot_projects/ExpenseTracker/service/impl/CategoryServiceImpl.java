package com.springboot_projects.ExpenseTracker.service.impl;

import com.springboot_projects.ExpenseTracker.dto.CategoryDTO;
import com.springboot_projects.ExpenseTracker.entity.Category;
import com.springboot_projects.ExpenseTracker.mapper.CategoryMapper;
import com.springboot_projects.ExpenseTracker.repository.CategoryRepository;
import com.springboot_projects.ExpenseTracker.service.CategoryService;
import lombok.*;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
//        Create CategoryDTO to Category Entity
        Category category = CategoryMapper.mapToCategory(categoryDTO);
//        Save Category entity into Category Database table - categories
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDTO(savedCategory);
    }

     @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Account does not exist."));
        return CategoryMapper.mapToCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> listAll = categoryRepository.findAll();
        return listAll.stream().map(CategoryMapper::mapToCategoryDTO).collect(Collectors.toList());
    }

    private boolean doesThisIdExist(Long id){
        return categoryRepository.existsById(id);
    }

    @Override
    public CategoryDTO patchCat(Long id, Map<String, Object> changes) {
        if(!doesThisIdExist(id)){
            return null;
        }
        Category category = categoryRepository.findById(id).get();
        changes.forEach((fields, value) -> {
            Field fieldsToBeUpdated = ReflectionUtils.findRequiredField(Category.class, fields);
            fieldsToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldsToBeUpdated, category, value);
        });
        categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("dont"));
        category.setName(categoryDTO.getName());
        return CategoryMapper.mapToCategoryDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO deleteCategory(Long id) {
        Category toBeDeleted = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No"));
        categoryRepository.deleteById(id);
        return CategoryMapper.mapToCategoryDTO(toBeDeleted);
    }
}
