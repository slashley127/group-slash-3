package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.Models.AppUser;
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
    public List<AppUser> getAllUsers() {
        return (List<AppUser>) userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public AppUser getUserById(@PathVariable Integer userId) {
        Optional<AppUser> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @PostMapping("/createUser")
    public AppUser createUser(@RequestBody AppUser user) {
        return userRepository.save(user);
    }

    @PutMapping ("update/{userId}")
    @ResponseBody
    public AppUser updateUser(@PathVariable Integer userId, AppUser updatedUser) {
        Optional<AppUser> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            AppUser existingUser = optionalUser.get();
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
