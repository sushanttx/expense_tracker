package com.springboot_projects.ExpenseTracker.mapper;

import com.springboot_projects.ExpenseTracker.dto.CategoryDTO;
import com.springboot_projects.ExpenseTracker.entity.Category;

public class CategoryMapper {
//    Map CategoryDTO to Category entity
    public static Category mapToCategory(CategoryDTO categoryDTO){
        return new Category(
                categoryDTO.id(),
                categoryDTO.name()
        );
    }
//        Map Category entity to CategoryDTO
    public  static CategoryDTO mapToCategoryDTO(Category category){
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }

}
