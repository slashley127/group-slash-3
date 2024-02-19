package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.DTO.AppUserDTO;
import com.slash3.travelapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
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


    @PostMapping("/email")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        UserDTO userDTO = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDTO);
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
