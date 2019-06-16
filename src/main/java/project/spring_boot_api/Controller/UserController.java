package project.spring_boot_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import project.spring_boot_api.DTO.LoginDTO;
import project.spring_boot_api.Model.User;
import project.spring_boot_api.Repository.UserRepository;

@RestController
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        if (userRepository.getUserByLogin(user.getLogin()) == null) {
            return userRepository.save(user);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login już isnieje");
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDTO payload) {
        User user =  userRepository.getUserByLoginAndPassword(payload.getLogin(), payload.getPassword());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zły login lub hasło");
        }
        return user;
    }
}
