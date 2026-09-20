
package com.BackEndProject.ecommerce.repository;

import com.BackEndProject.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}