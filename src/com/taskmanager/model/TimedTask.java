package com.taskmanager.model;

public class TimedTask extends Task  {

    int durationInMinutes;

    public TimedTask(int id, String description, int durationInMinutes) {
        super(id, description);
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String getDetail() {
        return "TimedTask{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", durationInMinutes=" + durationInMinutes +
                "} \n" ;
    }

}
