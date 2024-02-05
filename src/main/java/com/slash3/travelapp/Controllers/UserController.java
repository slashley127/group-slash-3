package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.Models.User;
import com.slash3.travelapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userrepository) {
        this.userRepository = userrepository;
    }
    @GetMapping("/test")
    @ResponseBody
    public String tester(){return "test";}
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping ("update/{userId}")
    @ResponseBody
    public User updateUser(@PathVariable Integer userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());

            return userRepository.save(existingUser);
        }

        return null;
    }
    @DeleteMapping("delete/{userId}")
    @ResponseBody
    public void deleteUser(@PathVariable Integer userId) {
        userRepository.deleteById(userId);
    }
}
