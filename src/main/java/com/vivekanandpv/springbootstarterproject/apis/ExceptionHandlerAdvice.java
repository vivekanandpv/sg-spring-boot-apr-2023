package com.vivekanandpv.springbootstarterproject.apis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handleException(RuntimeException exception) {
        //  log the exception
        return ResponseEntity.badRequest().build();
    }
}
