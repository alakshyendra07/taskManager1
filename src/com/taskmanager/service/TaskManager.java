package com.taskmanager.service;

import com.taskmanager.enums.TaskStatus;
import com.taskmanager.exception.TaskNotFoundException;
import com.taskmanager.model.RecurringTask;
import com.taskmanager.model.Task;
import com.taskmanager.model.TimedTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    int tid = 0;

    List<Task> tasks = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addTask(){
        System.out.print("Enter Task Description: ");
        String desc = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Task Type: 1.Normal Task, 2.TimedTask, 3.RecurringTask");
        int type = sc.nextInt();
        if (type == 1) {
            ++tid;
            Task t1 = new Task(tid, desc);
            tasks.add(t1);
            System.out.println("TASK ADDED");
        } else if (type == 2) {
            System.out.println("Enter the duration in minutes: ");
            int time = sc.nextInt();
            ++tid;
            Task t1 = new TimedTask(tid, desc, time);
            tasks.add(t1);
            System.out.println("TASK ADDED");

        } else if (type == 3) {
            System.out.println("Enter the duration in minutes: ");
            int time = sc.nextInt();
            System.out.println("Enter the repeat interval: ");
            int interval = sc.nextInt();
            ++tid;
            Task t1 = new RecurringTask(tid, desc, time, interval);
            tasks.add(t1);
            System.out.println("TASK ADDED");
        }
    }

    public void viewTask(){
        for (Task task: tasks){
            System.out.println(task.getDescription());
            task.getDetail();
        }
    }

    public int markTaskAsDone() throws TaskNotFoundException {

        viewTask();
        System.out.println("Enter the id of the task you want to mark as completed");
        int completedId = sc.nextInt();
        int res = 0;
        for (Task task : tasks) {
            if (task.getId() == completedId) {
                task.setStatus(TaskStatus.COMPLETED);
                System.out.println("MARKED SUCCESSFULLY");
                res = 1;
                break;
            }
        }
        if(res == 0){
            throw new TaskNotFoundException("Something went Wrong");
        }
        return 0;
    }

    public int deleteTask() throws TaskNotFoundException {
        System.out.println("Enter the task id you want to delete:");
        int del = sc.nextInt();
        int res = 0;
        for (Task task : tasks) {
            if (task.getId() == del) {
                tasks.remove(task);
                System.out.println("DELETED SUCCESSFULLY");
                res = 1;
            }
        }
        if(res == 0) {
            throw new TaskNotFoundException("Something went Wrong");
        }
        return 0;
    }

    public void filterAndDisplayTask(){
        System.out.println("The completed tasks are: ");
        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.COMPLETED) {
                task.getDetail();

            }
        }
    }

}
