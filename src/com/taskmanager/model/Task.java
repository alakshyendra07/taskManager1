package com.taskmanager.model;

import com.taskmanager.enums.TaskStatus;

public class Task {

    int id;
    String description;
    TaskStatus status = TaskStatus.PENDING;

    public Task(int id, String description){
        this.id = id;
        this.description = description;
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

    public int getId() {
        return id;
    }

    public String getDetail() {
        return  "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                "} \n" ;
    }
}
