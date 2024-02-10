package com.slash3.travelapp.Services;
import com.slash3.travelapp.Models.User;
import com.slash3.travelapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

        public User createUser(User user) {

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



    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));
    }

    public User getUserByEmail(String email) {
        return (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with email " + email));
    }

    public void deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId);
        }
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer userId, User userDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());


        return userRepository.save(user);
    }
}