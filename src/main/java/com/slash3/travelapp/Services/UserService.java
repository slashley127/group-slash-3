package com.slash3.travelapp.Services;

import com.slash3.travelapp.DTO.AppUserDTO;
import com.slash3.travelapp.Models.AppUser;
import com.slash3.travelapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    };

    public AppUserDTO createUser(AppUserDTO appUserDTO) {
        AppUser user = convertToEntity(appUserDTO);

        user.setPassword((passwordEncoder.encode(appUserDTO.getPassword())));

        AppUser newUser = userRepository.save(user);

        return convertToDTO(newUser);
    }

    public boolean verifyPassword(String username, String rawPassword) {
        Optional<AppUser> userOptional = userRepository.findByUserName(username);
        return userOptional.map(user -> passwordEncoder.matches(rawPassword, user.getPassword())).orElse(false);
    }


    public List<AppUserDTO> findAll() {
        List<AppUser> users = (List<AppUser>) userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AppUserDTO getUserById(Integer userId) {
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));
        return convertToDTO(user);
    }

    public AppUserDTO getUserByEmail(String email) {
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

    public AppUserDTO updateUser(Integer userId, AppUserDTO userDetails) {
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

    private AppUser convertToEntity(AppUserDTO appUserDTO) {
        return new AppUser(
                appUserDTO.getUserName(),
                appUserDTO.getPassword(),
                appUserDTO.getEmail(),
                appUserDTO.getFirstName(),
                appUserDTO.getLastName()
        );
    }

    private AppUserDTO convertToDTO(AppUser user) {
        return new AppUserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }


    public AppUser createUser(AppUser user) {

        if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("All fields are required");
        }

        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        return userRepository.save(user);
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
