package com.example.demo.exception;

import com.example.demo.controller.ApiControllersCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${exception.m1}")
    private String message1;

    @Value(value = "${exception.m2}")
    private String message2;

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = IdNotFoundException.class)
    public ResponseEntity idNotFoundException(IdNotFoundException idNotFoundException){
        log.error("Error",idNotFoundException.getCause());
        return new ResponseEntity<>(message1, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public  ResponseEntity InternalError(Exception exception){
        return new ResponseEntity<>(message2, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

