
package com.BackEndProject.ecommerce.service;

import com.BackEndProject.ecommerce.dto.UserRequestDTO;
import com.BackEndProject.ecommerce.dto.UserResponseDTO;
import com.BackEndProject.ecommerce.entity.User;
import com.BackEndProject.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create
    public UserResponseDTO saveUser(UserRequestDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User savedUser = userRepository.save(user);

        return convertToResponseDTO(savedUser);
    }

    // Read all
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    // Read one
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository
                .findById(id)
                .orElse(null);

        if (user == null) {
            return null;
        }

        return convertToResponseDTO(user);
    }

    // Update
    public UserResponseDTO updateUser(
            Long id,
            UserRequestDTO dto) {

        User existingUser =
                userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setPassword(dto.getPassword());
        existingUser.setRole(dto.getRole());

        User updatedUser =
                userRepository.save(existingUser);

        return convertToResponseDTO(updatedUser);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Entity → Response DTO
    private UserResponseDTO convertToResponseDTO(User user) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());

        return dto;
    }
}














































//package com.BackEndProject.ecommerce.service;
//import com.BackEndProject.ecommerce.entity.User;
//import com.BackEndProject.ecommerce.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//    public User getUserById(Long id){
//        return userRepository.findById(id).orElse(null);
//    }
//    public User updateUser(Long id, User user) {
//
//        User existingUser = userRepository.findById(id).orElse(null);
//
//        if (existingUser == null) {
//            return null;
//        }
//
//        existingUser.setName(user.getName());
//        existingUser.setEmail(user.getEmail());
//        existingUser.setPassword(user.getPassword());
//        existingUser.setRole(user.getRole());
//
//        return userRepository.save(existingUser);
//    }
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//}
