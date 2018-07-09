package controller;

import exception.user.AddCartCollectionException;
import exception.user.UserAddException;
import exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pojo.Error;

/**
 * @author panke
 * @date created in 2018/7/1 13:30
 */

@RestControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error userNotFound(UserNotFoundException e) {
        return new Error("User not found or password is incorrect", e.getUser().getUsername());
    }

    @ExceptionHandler(UserAddException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error userAddFailed(UserAddException e) {
        return new Error("User register failed", e.getUser().getUsername());
    }

    @ExceptionHandler(AddCartCollectionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error addCartCollectionFailed(AddCartCollectionException e) {
        return new Error("Add the good to cart failed", e.getCartCollection().toString());
    }
}
