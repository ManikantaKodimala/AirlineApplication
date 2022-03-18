package com.everest.airline.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FlightException.class)
    public final ResponseEntity<Object> handleAllExceptions(FlightException ex) {
        return new ResponseEntity<>("Flight Not Found", HttpStatus.OK);
    }
}
