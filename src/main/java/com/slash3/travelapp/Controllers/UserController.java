package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.DTO.UserDTO;
import com.slash3.travelapp.Models.AppUser;
import com.slash3.travelapp.Repositories.UserRepository;
import com.slash3.travelapp.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private static final String userSessionKey = "user";

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO newUserDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }


    @PostMapping("/email")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO, HttpSession session) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        // Retrieve user by email
        Optional<AppUser> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        AppUser user = optionalUser.get();

        // Check if password matches
        if (!user.getLoginAuth().isMatchingPassword(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        session.setAttribute("user", user);

        return ResponseEntity.ok("Login successful");
    }
    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
        UserDTO userDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer userId, @RequestBody UserDTO userDetails) {
        UserDTO updatedUser;
        updatedUser = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }
}
