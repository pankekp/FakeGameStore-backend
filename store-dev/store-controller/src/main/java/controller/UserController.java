package controller;

import exception.tx.TxException;
import exception.user.AddCartCollectionException;
import exception.user.AddOrderException;
import exception.user.DeleteCartItemException;
import exception.user.UpdateCartNumException;
import exception.user.UserAddException;
import exception.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.CartCollection;
import pojo.CartItem;
import pojo.ContactInfoCollection;
import pojo.Orders;
import pojo.Success;
import pojo.User;
import service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @author panke
 * @date created in 2018/6/10 19:39
 */

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
            System.out.println(e.getMessage());
            throw new AddCartCollectionException(cartCollection);
        }
    }

    @GetMapping(value = {"/getCart"})
    public List<CartItem> getCart(User user) {
        return userService.getCartItems(user.getId());
    }

    @PutMapping(value = {"/updateCart"})
    public Success updateCart(@RequestBody CartItem[] cartItems) {
        System.out.println(cartItems[0].getGameNum());
        List<CartItem> cartItemList = Arrays.asList(cartItems);
        int rows = userService.modifyCartItemNum(cartItemList);
        if (rows != cartItemList.size()) {
            throw new UpdateCartNumException(cartItemList);
        }
        return new Success("Update cart num successfully", null);
    }

    @DeleteMapping(value = {"/deleteCart/{cartItemId}"})
    public Success deleteCart(@PathVariable int cartItemId) {
        int row = userService.deleteCartItem(cartItemId);
        if (row != 1) {
            throw new DeleteCartItemException(cartItemId);
        }
        return new Success("Delete cart item successfully", cartItemId + "");
    }

    @PostMapping(value = {"/addOrder"})
    public Success addOrder(@RequestBody ContactInfoCollection contactInfoCollection) {
        int cartItemsNum = userService.getCartItems(contactInfoCollection.getUserId()).size();
        int rows;
        try {
            rows = userService.submitOrder(contactInfoCollection.getUserId(), contactInfoCollection.getContactInfo());
        } catch (TxException e) {
            System.out.println(e.getMessage());
            throw new AddOrderException(contactInfoCollection.getUserId());
        }
        if (cartItemsNum != rows) {
            throw new AddOrderException(contactInfoCollection.getUserId());
        }
        return new Success("Add order successfully", "");
    }

    @GetMapping(value = {"/getOrder/{userId}"})
    public List<Orders> getOrder(@PathVariable int userId) {
        return userService.getOrders(userId);
    }
}
