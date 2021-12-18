package com.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GeneralExceptionHandel {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> bookNotFoundExceptionHandeler(BookNotFoundException exception, WebRequest request){

        return new ResponseEntity<>(new ErrorDetails(exception.getMessage(),new Date() , request.getDescription(true)), HttpStatus.BAD_REQUEST);


    }
}
