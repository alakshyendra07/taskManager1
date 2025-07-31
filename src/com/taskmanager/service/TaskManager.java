package com.taskmanager.service;

import com.taskmanager.enums.TaskStatus;
import com.taskmanager.exception.TaskNotFoundException;
import com.taskmanager.model.RecurringTask;
import com.taskmanager.model.Task;
import com.taskmanager.model.TimedTask;

import java.util.*;

public class TaskManager {

    int tid = 0;

    HashMap<Integer,Task> tasks = new LinkedHashMap<>();
    Scanner sc = new Scanner(System.in);

    public void addTask() throws TaskNotFoundException {
        System.out.print("Enter Task Description: ");
        String desc = sc.nextLine();
        String check = "^.*[A-Z].+$";
        if (desc.matches(check)) {
            System.out.println("Enter Task Type: 1.Normal Task, 2.TimedTask, 3.RecurringTask");
            int type = sc.nextInt();
            sc.nextLine();
            if (type == 1 || type == 2 || type == 3) {
                ++tid;
                if (type == 1) {
                    Task t1 = new Task(tid, desc);
                    tasks.put(tid, t1);
                } else if (type == 2) {
                    System.out.println("Enter the duration in minutes: ");
                    int time = sc.nextInt();
                    Task t1 = new TimedTask(tid, desc, time);
                    tasks.put(tid, t1);
                } else if (type == 3) {
                    System.out.println("Enter the duration in minutes: ");
                    int time = sc.nextInt();
                    System.out.println("Enter the repeat interval: ");
                    int interval = sc.nextInt();
                    Task t1 = new RecurringTask(tid, desc, time, interval);
                    tasks.put(tid, t1);
                }
                System.out.println("TASK ADDED");
            } else {
                throw new TaskNotFoundException("Something went Wrong");
            }
        }
        else {
            throw new TaskNotFoundException("Something went Wrong");
        }
    }

    public void viewTask(){
        tasks.forEach((k,v)-> System.out.print(v.getDetail()));
    }

    public void markTaskAsDone() throws TaskNotFoundException {
        viewTask();
        System.out.println("Enter the id of the task you want to mark as completed");
        int completedId = sc.nextInt();
        if (tasks.containsKey(completedId)){
            Task task = tasks.get(completedId);
            task.setStatus(TaskStatus.COMPLETED);
            tasks.replace(completedId,task);
            System.out.println("TASK MARKED AS COMPLETED!");
        }
        else {
            throw new TaskNotFoundException("Something went Wrong");
        }
    }

    public void deleteTask() throws TaskNotFoundException {
        System.out.println("Enter the task id you want to delete:");
        int del = sc.nextInt();
        if (tasks.containsKey(del)){
            tasks.remove(del);
            System.out.println("TASK DELETED");
        }
        else {
            throw new TaskNotFoundException("Something went Wrong");
        }

    }

    public void filterAndDisplayTask(){
        System.out.println("The completed tasks are: ");
        tasks.values().stream().filter(
                        task -> task.getStatus() == TaskStatus.COMPLETED)
                .forEach(task ->  System.out.println(task.getDetail()));
    }

}
