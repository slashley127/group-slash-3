package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.DTO.AppUserDTO;
import com.slash3.travelapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AppUserDTO> createUser(@RequestBody AppUserDTO appUserDTO) {
        AppUserDTO newAppUserDTO = userService.createUser(appUserDTO);
        return new ResponseEntity<>(newAppUserDTO, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public List<AppUserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<AppUserDTO> getUserById(@PathVariable Integer userId) {
        AppUserDTO appUserDTO = userService.getUserById(userId);
        return ResponseEntity.ok(appUserDTO);
    }
    @GetMapping("/email")
    public ResponseEntity<AppUserDTO> getUserByEmail(@RequestParam String email) {
        AppUserDTO appUserDTO = userService.getUserByEmail(email);
        return ResponseEntity.ok(appUserDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<AppUserDTO> updateUser(@PathVariable Integer userId, @RequestBody AppUserDTO userDetails) {
        AppUserDTO updatedUser = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }
}
