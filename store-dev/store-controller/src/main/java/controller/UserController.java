package controller;

import exception.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;

/**
 * @author panke
 * @date created in 2018/6/10 19:39
 */

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/login"})
    public User login(User user) {
        User existUser = userService.login(user);
        if (existUser == null) {
            throw new UserNotFoundException(user);
        }
        return existUser;
    }
}
