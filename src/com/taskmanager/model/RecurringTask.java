package com.taskmanager.model;

import com.taskmanager.enums.TaskStatus;

public class RecurringTask extends Task{
    int repeatInterval;
    int durationInMinutes;
    public RecurringTask(int id, String description, int repeatInterval, int durationInMinutes) {

        super(id, description);
        this.repeatInterval = repeatInterval;
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public void getDetail() {
        System.out.println( "RecurringTask{" +
                "repeatInterval=" + repeatInterval +
                ", durationInMinutes=" + durationInMinutes +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}');
    }
}
