package com.smartfox.SpringTodo.Model;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String name;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @NonNull
    private String description;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Task() { }
    
    public Task(Long id, String name, TaskStatus status, String description, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.description = description;
        
        if (createdAt == null)
            this.createdAt = LocalDate.now();
        else
            this.createdAt = createdAt;
        if (updatedAt == null)
            this.updatedAt = LocalDate.now();
        else    
            this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
