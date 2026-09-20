
package com.BackEndProject.ecommerce.controller;

import com.BackEndProject.ecommerce.dto.ProductRequestDTO;
import com.BackEndProject.ecommerce.dto.ProductResponseDTO;
import com.BackEndProject.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create
    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO dto) {
        return productService.saveProduct(dto);
    }

    // Read all
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // Read one
    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO dto) {
        return productService.updateProduct(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }
}
























































































































//package com.BackEndProject.ecommerce.controller;
//
//import com.BackEndProject.ecommerce.entity.Product;
//import com.BackEndProject.ecommerce.service.ProductService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//
//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    // Create
//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.saveProduct(product);
//    }
//
//    // Read all
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    // Read one
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
//
//    // Update
//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
//        return productService.updateProduct(id, product);
//    }
//
//    // Delete
//    @DeleteMapping("/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//        return "Product deleted successfully";
//    }
//}