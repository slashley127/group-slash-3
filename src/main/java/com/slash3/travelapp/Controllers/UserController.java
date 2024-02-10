package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.DTO.UserDTO;
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
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO newUserDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
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
    @GetMapping("/email")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        UserDTO userDTO = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer userId, @RequestBody UserDTO userDetails) {
        UserDTO updatedUser = userService.updateUser(userId, userDetails);
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
