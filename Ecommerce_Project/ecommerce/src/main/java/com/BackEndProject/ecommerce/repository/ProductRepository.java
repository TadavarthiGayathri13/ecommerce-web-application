package com.BackEndProject.ecommerce.repository;

import com.BackEndProject.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}