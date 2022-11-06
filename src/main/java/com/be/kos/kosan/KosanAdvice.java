package com.be.kos.kosan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class KosanAdvice {

    @ResponseBody
    @ExceptionHandler(KosanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String kosanNotFoundHandler(KosanNotFoundException exception){
        return exception.getMessage();
    }
}
