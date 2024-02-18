package com.slash3.travelapp.Services;
import com.slash3.travelapp.DTO.UserDTO;
import com.slash3.travelapp.Models.AppUser;
import com.slash3.travelapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        AppUser user = convertToEntity(userDTO);
        AppUser newUser = userRepository.save(user);
        return convertToDTO(newUser);
    }

    public List<UserDTO> findAll() {
        List<AppUser> users = (List<AppUser>) userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer userId) {
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));
        return convertToDTO(user);
    }

    public UserDTO getUserByEmail(String email) {
        AppUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with email " + email));
        return convertToDTO(user);
    }

    public void deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId);
        }
        userRepository.deleteById(userId);
    }

    public UserDTO updateUser(Integer userId, UserDTO userDetails) {
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setUserName(userDetails.getUserName());


        AppUser updatedUser = userRepository.save(user);

        return convertToDTO(updatedUser);
    }

    private AppUser convertToEntity(UserDTO userDTO) {
        return new AppUser(
                userDTO.getUserName(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                userDTO.getFirstName(),
                userDTO.getLastName()
        );
    }

    private UserDTO convertToDTO(AppUser user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }


//    public AppUser createUser(AppUser user) {
//
//        if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getPassword() == null) {
//            throw new IllegalArgumentException("All fields are required");
//        }
//
//        if (!isValidEmail(user.getEmail())) {
//            throw new IllegalArgumentException("Invalid email format");
//        }
//
//        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Email already exists");
//        }
//
//        return userRepository.save(user);
//    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
