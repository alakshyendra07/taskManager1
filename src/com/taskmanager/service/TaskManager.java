package com.taskmanager.service;

import com.taskmanager.enums.TaskStatus;
import com.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void viewTask(){
        for (Task task: tasks){
            System.out.println("view task "+ task.getDescription());
            task.getDetail();
        }
    }

    public int markTaskAsDone(int id){

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(TaskStatus.COMPLETED);
                return 1;
            }
        }
        return 0;
    }

    public int deleteTask(int id){
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                return 1;
            }
        }
        return 0;

    }

    public void filterAndDisplayTask(){
        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.COMPLETED) {
                task.getDetail();

            }
        }
    }

}
