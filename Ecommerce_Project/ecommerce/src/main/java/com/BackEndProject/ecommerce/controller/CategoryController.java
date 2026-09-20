
package com.BackEndProject.ecommerce.controller;

import com.BackEndProject.ecommerce.dto.CategoryRequestDTO;
import com.BackEndProject.ecommerce.dto.CategoryResponseDTO;
import com.BackEndProject.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Create
    @PostMapping
    public CategoryResponseDTO createCategory(@Valid @RequestBody CategoryRequestDTO dto) {
        return categoryService.saveCategory(dto);
    }

    // Read all
    @GetMapping
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Read one
    @GetMapping("/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Update
    @PutMapping("/{id}")
    public CategoryResponseDTO updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDTO dto) {

        return categoryService.updateCategory(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }
}

























































//package com.BackEndProject.ecommerce.controller;
//
//import com.BackEndProject.ecommerce.entity.Category;
//import com.BackEndProject.ecommerce.service.CategoryService;
//import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/categories")
//public class CategoryController {
//
//    private final CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    // Create
//    @PostMapping
//    public Category createCategory(@Valid @RequestBody Category category) {
//        return categoryService.saveCategory(category);
//    }
//
//    // Read all
//    @GetMapping
//    public List<Category> getAllCategories() {
//        return categoryService.getAllCategories();
//    }
//
//    // Read one
//    @GetMapping("/{id}")
//    public Category getCategoryById(@PathVariable Long id) {
//        return categoryService.getCategoryById(id);
//    }
//
//    // Update
//    @PutMapping("/{id}")
//    public Category updateCategory(@Valid @PathVariable Long id, @RequestBody Category category) {
//
//        return categoryService.updateCategory(id, category);
//    }
//
//    // Delete
//    @DeleteMapping("/{id}")
//    public String deleteCategory(@PathVariable Long id) {
//        categoryService.deleteCategory(id);
//        return "Category deleted successfully";
//    }
//}