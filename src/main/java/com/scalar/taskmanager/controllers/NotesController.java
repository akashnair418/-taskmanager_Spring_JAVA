package com.scalar.taskmanager.controllers;

import com.scalar.taskmanager.dto.CreateNoteDTO;
import com.scalar.taskmanager.dto.CreateNoteResponseDTO;
import com.scalar.taskmanager.entities.NoteEntity;
import com.scalar.taskmanager.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {

    private NoteService noteService;
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") int taskId) {
        var notes = noteService.getNotesFortask(taskId);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("taskId") Integer taskId,
            @RequestBody CreateNoteDTO body) {
        var note = noteService.addNoteForTask(taskId,body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId, note));
    }
}
