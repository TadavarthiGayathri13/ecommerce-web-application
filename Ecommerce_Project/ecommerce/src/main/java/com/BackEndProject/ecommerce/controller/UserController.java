
package com.BackEndProject.ecommerce.controller;
import com.BackEndProject.ecommerce.dto.UserRequestDTO;
import com.BackEndProject.ecommerce.dto.UserResponseDTO;
import com.BackEndProject.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create
    @PostMapping
    public UserResponseDTO createUser(
            @Valid @RequestBody UserRequestDTO dto) {

        return userService.saveUser(dto);
    }

    // Read all
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {

        return userService.getAllUsers();
    }

    // Read one
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(
            @PathVariable Long id) {

        return userService.getUserById(id);
    }

    // Update
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO dto) {

        return userService.updateUser(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }
}
















































//package com.BackEndProject.ecommerce.controller;
//import com.BackEndProject.ecommerce.entity.User;
//import com.BackEndProject.ecommerce.service.UserService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    //create
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//    //Read all
//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }
//    //Read one user by ID
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }
//    //Update
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//    //delete
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "User deleted successfully";
//    }
//
//}
