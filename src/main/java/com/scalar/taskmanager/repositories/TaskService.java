package com.scalar.taskmanager.repositories;

import com.scalar.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {

    private ArrayList<TaskEntity> tasks =  new ArrayList<>();
    private int taskid = 1;

    public TaskEntity addTask(String title, String description, String deadline) {
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setId(taskid);
        //task.setDeadline(new Date(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskid++;
        return task;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
       return tasks.stream().filter(task -> task.getId() == id).findFirst().get();
    }
}
