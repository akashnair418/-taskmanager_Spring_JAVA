package com.scalar.taskmanager.controllers;

import com.scalar.taskmanager.dto.CreateTaskDTO;
import com.scalar.taskmanager.entities.TaskEntity;
import com.scalar.taskmanager.repositories.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        var tasks = taskService.getTasks();
        if(tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") int id) {
        var task = taskService.getTaskById(id);
        if(task == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) {
        var task = taskService.addTask(body.getTitle() ,body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }
}
