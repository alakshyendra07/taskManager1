package com.taskmanager.model;

public class RecurringTask extends Task{
    int repeatInterval;
    int durationInMinutes;
    public RecurringTask(int id, String description, int repeatInterval, int durationInMinutes) {

        super(id, description);
        this.repeatInterval = repeatInterval;
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String getDetail() {
        return  "RecurringTask{" +
                "repeatInterval=" + repeatInterval +
                ", durationInMinutes=" + durationInMinutes +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                "} \n" ;
    }
}
