package com.scalar.taskmanager.controllers;

import com.scalar.taskmanager.dto.CreateTaskDTO;
import com.scalar.taskmanager.dto.ErrorResponseDTO;
import com.scalar.taskmanager.dto.TaskResponseDTO;
import com.scalar.taskmanager.dto.UpdateTaskDTO;
import com.scalar.taskmanager.entities.TaskEntity;
import com.scalar.taskmanager.service.NoteService;
import com.scalar.taskmanager.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final NoteService noteService;
    private ModelMapper modelMapper = new ModelMapper();

    public TaskController(TaskService taskService, NoteService noteService) {
        this.taskService = taskService;
        this.noteService = noteService;
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
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id") int id) {
        var task = taskService.getTaskById(id);
        var notes = noteService.getNotesFortask(id);

        if(task == null) {
            return ResponseEntity.noContent().build();
        }
        var taskResponse = modelMapper.map(task, TaskResponseDTO.class);
        taskResponse.setNotes(notes);

        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task = taskService.addTask(body.getTitle() ,body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") int id, @RequestBody UpdateTaskDTO body) throws ParseException {
       var task = taskService.updateTask(id, body.getDescription(), body.getDeadline(),body.getCompleted());
       if(task == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(task);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e) {
        if(e instanceof ParseException) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid Date Format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Invalid Server Error"));
    }
}
