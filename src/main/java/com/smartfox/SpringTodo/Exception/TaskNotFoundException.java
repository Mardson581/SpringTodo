package com.smartfox.SpringTodo.Exception;

public class TaskNotFoundException extends RuntimeException  {
    
    public TaskNotFoundException(Long id) {
        super(String.format("Task with id %d was not found", id));
    }
}
