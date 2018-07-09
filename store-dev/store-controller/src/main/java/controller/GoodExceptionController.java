package controller;

import exception.good.GoodNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pojo.Error;

/**
 * @author panke
 * @date created in 2018/6/17 21:21
 */

@RestControllerAdvice
public class GoodExceptionController {

    @ExceptionHandler(GoodNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error goodNotFound(int id) {
        return new Error("good is not found:", id + "");
    }
}
