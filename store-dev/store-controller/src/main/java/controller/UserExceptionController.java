package controller;

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
        String username = e.getUser().getUsername();
        return new Error("user not found", username);
    }
}
