package com.daily.session_four.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> handleConstraintViolation(ConstraintViolationException exception){
        Map<String, String> errors = new HashMap<>();

        exception.getConstraintViolations()
                .forEach(constraintViolation -> errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));

        return ResponseEntity.badRequest().body(errors);
    }
}
