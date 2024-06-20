package com.example.springmongodb.exception;

import com.example.springmongodb.model.response.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(UnSuccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseObject<Object> UnSuccessHandler(UnSuccessException ex) {
        return new ResponseObject<>(false, com.example.springmongodb.model.response.ResponseStatus.UNSUCCESS, ex.getMessage());
    }
}
