package com.springboot_projects.ExpenseTracker.controller;

import com.springboot_projects.ExpenseTracker.dto.CategoryDTO;
//import com.springboot_projects.ExpenseTracker.entity.Category;
//import com.springboot_projects.ExpenseTracker.mapper.CategoryMapper;
import com.springboot_projects.ExpenseTracker.service.CategoryService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("expensetracker")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping("create")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO){
        CategoryDTO categoryDTO1 = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO1, HttpStatus.CREATED);
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable Long id){
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("all")
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PatchMapping("patch/{id}")
    public ResponseEntity<CategoryDTO> changeName(@PathVariable Long id, @RequestBody Map<String, Object> changes){
        return ResponseEntity.ok(categoryService.patchCat(id, changes));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody @Valid CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleletId(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Account Deleted.");
    }

}
