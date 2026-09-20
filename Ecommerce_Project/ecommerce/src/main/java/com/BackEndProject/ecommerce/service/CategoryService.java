
package com.BackEndProject.ecommerce.service;

import com.BackEndProject.ecommerce.dto.CategoryRequestDTO;
import com.BackEndProject.ecommerce.dto.CategoryResponseDTO;
import com.BackEndProject.ecommerce.entity.Category;
import com.BackEndProject.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create
    public CategoryResponseDTO saveCategory(CategoryRequestDTO dto) {

        Category category = new Category();

        category.setName(dto.getName());

        Category savedCategory = categoryRepository.save(category);

        return convertToResponseDTO(savedCategory);
    }

    // Read all
    public List<CategoryResponseDTO> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    // Read one
    public CategoryResponseDTO getCategoryById(Long id) {

        Category category = categoryRepository
                .findById(id)
                .orElse(null);

        if (category == null) {
            return null;
        }

        return convertToResponseDTO(category);
    }

    // Update
    public CategoryResponseDTO updateCategory(
            Long id,
            CategoryRequestDTO dto) {

        Category existingCategory =
                categoryRepository.findById(id).orElse(null);

        if (existingCategory == null) {
            return null;
        }

        existingCategory.setName(dto.getName());

        Category updatedCategory =
                categoryRepository.save(existingCategory);

        return convertToResponseDTO(updatedCategory);
    }

    // Delete
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // Entity → Response DTO
    private CategoryResponseDTO convertToResponseDTO(
            Category category) {

        CategoryResponseDTO dto = new CategoryResponseDTO();

        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;
    }
}


















































//package com.BackEndProject.ecommerce.service;
//
//import com.BackEndProject.ecommerce.dto.CategoryRequestDTO;
//import com.BackEndProject.ecommerce.entity.Category;
//import com.BackEndProject.ecommerce.repository.CategoryRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategoryService {
//
//    private final CategoryRepository categoryRepository;
//
//    public CategoryService(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    // Create
//    public Category saveCategory(CategoryRequestDTO dto) {
//
//        Category category = new Category();
//
//        category.setName(dto.getName());
//
//        return categoryRepository.save(category);
//    }
//
//    // Read all
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    // Read one
//    public Category getCategoryById(Long id) {
//        return categoryRepository.findById(id).orElse(null);
//    }
//
//    // Update
//    public Category updateCategory(
//            Long id,
//            CategoryRequestDTO dto) {
//
//        Category existingCategory =
//                categoryRepository.findById(id).orElse(null);
//
//        if (existingCategory == null) {
//            return null;
//        }
//
//        existingCategory.setName(dto.getName());
//
//        return categoryRepository.save(existingCategory);
//    }
//
//    // Delete
//    public void deleteCategory(Long id) {
//        categoryRepository.deleteById(id);
//    }
//}
//
//
//
//
//
//
//
//
























































//package com.BackEndProject.ecommerce.service;
//
//import com.BackEndProject.ecommerce.entity.Category;
//import com.BackEndProject.ecommerce.repository.CategoryRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategoryService {
//
//    private final CategoryRepository categoryRepository;
//
//    public CategoryService(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    // Create
//    public Category saveCategory(Category category) {
//        return categoryRepository.save(category);
//    }
//
//    // Read all
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    // Read one
//    public Category getCategoryById(Long id) {
//        return categoryRepository.findById(id).orElse(null);
//    }
//
//    // Update
//    public Category updateCategory(Long id, Category category) {
//
//        Category existingCategory =
//                categoryRepository.findById(id).orElse(null);
//
//        if (existingCategory == null) {
//            return null;
//        }
//
//        existingCategory.setName(category.getName());
//
//        return categoryRepository.save(existingCategory);
//    }
//
//    // Delete
//    public void deleteCategory(Long id) {
//        categoryRepository.deleteById(id);
//    }
//}