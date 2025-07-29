package com.taskmanager.model;

import com.taskmanager.enums.TaskStatus;

public class TimedTask extends Task  {

    int durationInMinutes;

    public TimedTask(int id, String description, int durationInMinutes) {
        super(id, description);
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public void getDetail() {
        System.out.println("TimedTask{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", durationInMinutes=" + durationInMinutes +
                '}');
    }

}
