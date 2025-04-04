package com.smartfox.SpringTodo.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.smartfox.SpringTodo.Exception.TaskNotFoundException;
import com.smartfox.SpringTodo.Model.Task;
import com.smartfox.SpringTodo.Model.TaskStatus;
import com.smartfox.SpringTodo.Repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @PostMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        Task savedTask = repository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Task> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(()-> new TaskNotFoundException(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task newTask) {
        return repository.findById(id)
            .map((task)-> {
                task.setName(newTask.getName());
                task.setStatus(newTask.getStatus());
                task.setDescription(newTask.getDescription());
                task.setUpdatedAt(LocalDate.now());
                return new ResponseEntity<>(repository.save(task), HttpStatus.OK);
            })
            .orElseGet(()-> {
                return new ResponseEntity<>(repository.save(newTask), HttpStatus.CREATED);
            });
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.findById(id)
            .ifPresentOrElse(
                (task)-> {
                    repository.deleteById(id);
                },
                ()-> {
                    throw new TaskNotFoundException(id);
                }
            );
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<Task> complete(@PathVariable Long id, @RequestParam TaskStatus status) {
        return repository.findById(id)
            .map((task)-> {
                task.setStatus(status);
                task.setCreatedAt(LocalDate.now());
                return new ResponseEntity<>(repository.save(task), HttpStatus.OK);
            })
            .orElseThrow(()-> new TaskNotFoundException(id));
    }
}
