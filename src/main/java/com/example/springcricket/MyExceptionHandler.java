package com.example.springcricket;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public String NotFoundExceptionHandler(NotFoundException e){
        return e.getMessage() ;
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String ExceptionHandler(Exception e){
        return e.getMessage() ;
    }

}
