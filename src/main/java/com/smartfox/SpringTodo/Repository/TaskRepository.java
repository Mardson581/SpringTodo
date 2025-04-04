package com.smartfox.SpringTodo.Repository;

import org.springframework.data.repository.CrudRepository;
import com.smartfox.SpringTodo.Model.Task;
import com.smartfox.SpringTodo.Model.TaskStatus;

public interface TaskRepository extends CrudRepository<Task, Long> {
    public Task findByName(String name);
    public Iterable<Task> findByStatus(TaskStatus status);
}
