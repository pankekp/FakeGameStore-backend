package controller;

import exception.tx.TxException;
import exception.user.AddCartCollectionException;
import exception.user.UserAddException;
import exception.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.CartCollection;
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

    @GetMapping(value = {"/findUsername"})
    public User findUsername(User user) {
        return userService.validateUsername(user);
    }

    @PostMapping(value = {"/register"})
    public User register(@RequestBody User user) {
        System.out.println(user.getUsername());
        int addUserNum = userService.register(user);
        if (addUserNum == 0) {
            throw new UserAddException(user);
        }
        return new User(null, user.getUsername(), null);
    }

    @PostMapping(value = {"/addToCart"})
    public CartCollection addToCart(@RequestBody CartCollection cartCollection) {
        try {
            return userService.addToCart(cartCollection);
        } catch (TxException e) {
            System.out.println(e.getMessage() + "in controller");
            throw new AddCartCollectionException(cartCollection);
        }
    }
}
