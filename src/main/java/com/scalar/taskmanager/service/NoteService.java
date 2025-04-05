package com.scalar.taskmanager.service;

import com.scalar.taskmanager.entities.NoteEntity;
import com.scalar.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {

    private TaskService taskService;
    private HashMap<Integer, TaskNotesHolder> taskNotesHolder = new HashMap<>();

    public NoteService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNotesHolder{
        protected int nodeID =1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    public List<NoteEntity> getNotesFortask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null) return null;
        if(taskNotesHolder.get(taskId) == null)
            taskNotesHolder.put(taskId, new TaskNotesHolder());

        return taskNotesHolder.get(taskId).notes;
    }

    public NoteEntity addNoteForTask(int taskId, String title, String body) {
        TaskEntity task = taskService.getTaskById(taskId);
        if (task == null) {
            return null;
        }
        if (taskNotesHolder.get(taskId) == null) {
            taskNotesHolder.put(taskId, new TaskNotesHolder());
        }

        TaskNotesHolder newtaskNoteHolder = taskNotesHolder.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setTitle(title);
        note.setBody(body);
        newtaskNoteHolder.notes.add(note);
        newtaskNoteHolder.nodeID++;
        return note;
    }
}
