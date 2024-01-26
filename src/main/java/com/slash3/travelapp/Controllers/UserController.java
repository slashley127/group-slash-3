import com.slash3.travelapp.Models.User;
import com.slash3.travelapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private final UserRepository userrepository;

    public UserController(UserRepository userrepository) {
        this.userrepository = userrepository;

    }
    @GetMapping("/test")
    @ResponseBody
    public String tester(){return "test";}
    @GetMapping()
    public List<User> getAllUsers() {
        return (List<User>) userrepository.findAll();
    }

    @GetMapping(value="/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        Optional<User> optionalUser = userrepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userrepository.save(user);
    }

    @PostMapping (value="update/{userId}")
    @ResponseBody
    public User updateUser(Integer userId, User updatedUser) {
        Optional<User> optionalUser = userrepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());

            return userrepository.save(existingUser);
        }

        return null;
    }
    @PostMapping("delete/{userId}")
    @ResponseBody
    public void deleteUser(Integer userId) {
        userrepository.deleteById(userId);
    }
}