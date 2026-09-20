package com.BackEndProject.ecommerce.service;

import com.BackEndProject.ecommerce.dto.ProductRequestDTO;
import com.BackEndProject.ecommerce.dto.ProductResponseDTO;
import com.BackEndProject.ecommerce.entity.Category;
import com.BackEndProject.ecommerce.entity.Product;
import com.BackEndProject.ecommerce.repository.CategoryRepository;
import com.BackEndProject.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // Create
    public ProductResponseDTO saveProduct(ProductRequestDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);

        if (category == null) {
            return null;
        }

        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        return convertToResponseDTO(savedProduct);
    }

    // Read all
    public List<ProductResponseDTO> getAllProducts() {

        return productRepository.findAll().stream().map(this::convertToResponseDTO).toList();
    }

    // Read one
    public ProductResponseDTO getProductById(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        return convertToResponseDTO(product);
    }

    // Update
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }

        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);

        if (category == null) {
            return null;
        }

        existingProduct.setName(dto.getName());
        existingProduct.setDescription(dto.getDescription());
        existingProduct.setPrice(dto.getPrice());
        existingProduct.setStock(dto.getStock());
        existingProduct.setCategory(category);

        Product updatedProduct =
                productRepository.save(existingProduct);

        return convertToResponseDTO(updatedProduct);
    }

    // Delete
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Entity → Response DTO
    private ProductResponseDTO convertToResponseDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());

        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
            dto.setCategoryName(product.getCategory().getName());
        }

        return dto;
    }
}














































































//package com.BackEndProject.ecommerce.service;
//
//import com.BackEndProject.ecommerce.entity.Product;
//import com.BackEndProject.ecommerce.repository.ProductRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    private final ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    // Create
//    public Product saveProduct(Product product) {
//        return productRepository.save(product);
//    }
//
//    // Read all
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    // Read one
//    public Product getProductById(Long id) {
//        return productRepository.findById(id).orElse(null);
//    }
//
//    // Update
//    public Product updateProduct(Long id, Product product) {
//
//        Product existingProduct = productRepository.findById(id).orElse(null);
//
//        if (existingProduct == null) {
//            return null;
//        }
//
//        existingProduct.setName(product.getName());
//        existingProduct.setDescription(product.getDescription());
//        existingProduct.setPrice(product.getPrice());
//        existingProduct.setStock(product.getStock());
//        existingProduct.setCategory(product.getCategory());
//
//        return productRepository.save(existingProduct);
//    }
//
//    // Delete
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }
//}