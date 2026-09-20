package com.BackEndProject.ecommerce.repository;
import com.BackEndProject.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
