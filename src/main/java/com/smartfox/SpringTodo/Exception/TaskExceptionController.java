package com.smartfox.SpringTodo.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class TaskExceptionController {
    
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleTaskNotFoundException(TaskNotFoundException ex) {
        return Map.of("message", ex.getMessage());
    }
}