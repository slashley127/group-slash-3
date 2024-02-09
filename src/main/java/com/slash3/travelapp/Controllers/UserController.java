package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.Models.User;
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
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/email")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }
}

//import java.util.List;
//import java.util.Optional;
//@CrossOrigin
//@RestController
//@RequestMapping("/api")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    @PostMapping("/register")
//    public User createUser(@RequestBody User user) {
//        User newUser = userService.createUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//    }


//
//    @GetMapping("/{userId}")
//    public User getUserById(@PathVariable Integer userId) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        return optionalUser.orElse(null);
//    }
//
//    @PostMapping("/createUser")
//    public User createUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }
//
//    @PutMapping ("update/{userId}")
//    @ResponseBody
//    public User updateUser(@PathVariable Integer userId, User updatedUser) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//
//        if (optionalUser.isPresent()) {
//            User existingUser = optionalUser.get();
//            existingUser.setUserName(updatedUser.getUserName());
//            existingUser.setEmail(updatedUser.getEmail());
//            existingUser.setPassword(updatedUser.getPassword());
//
//            return userRepository.save(existingUser);
//        }
//
//        return null;
//    }
//    @DeleteMapping("delete/{userId}")
//    @ResponseBody
//    public void deleteUser(@PathVariable Integer userId) {
//        userRepository.deleteById(userId);
//    }
//}
