package com.taskmanager;

import com.taskmanager.exception.TaskNotFoundException;
import com.taskmanager.model.Task;
import com.taskmanager.model.TimedTask;
import com.taskmanager.model.RecurringTask;
import com.taskmanager.service.TaskManager;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        int tid = 0;
        TaskManager taskManager = new TaskManager();
        do {
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. View Completed Tasks");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Task Description: ");
                        String desc = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter Task Type: 1.Normal Task, 2.TimedTask, 3.RecurringTask");
                        int type = sc.nextInt();
                        if (type == 1) {
                            ++tid;
                            Task t1 = new Task(tid, desc);
                            taskManager.addTask(t1);
                            System.out.println("TASK ADDED");
                        } else if (type == 2) {
                            System.out.println("Enter the duration in minutes: ");
                            int time = sc.nextInt();
                            ++tid;
                            Task t1 = new TimedTask(tid, desc, time);
                            taskManager.addTask(t1);
                            System.out.println("TASK ADDED");

                        } else if (type == 3) {
                            System.out.println("Enter the duration in minutes: ");
                            int time = sc.nextInt();
                            System.out.println("Enter the repeat interval: ");
                            int interval = sc.nextInt();
                            ++tid;
                            Task t1 = new RecurringTask(tid, desc, time, interval);
                            taskManager.addTask(t1);
                            System.out.println("TASK ADDED");
                        }


                        break;

                    case 2:
                        taskManager.viewTask();
                        break;
                    case 3:
                        taskManager.viewTask();
                        System.out.println("Enter the id of the task you want to mark as completed");
                        int completedId = sc.nextInt();
                        if (taskManager.markTaskAsDone(completedId) == 1) {
                            System.out.println("MARKED SUCCESSFULLY");
                        } else {
                            System.out.println("FIELD NOT FOUND");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the task id you want to delete:");
                        int del = sc.nextInt();
                        if (taskManager.deleteTask(del) == 1) {
                            System.out.println("DELETED SUCCESSFULLY");
                        } else {
                            System.out.println("FIELD NOT FOUND");
                        }
                        break;
                    case 5:
                        System.out.println("The completed tasks are: ");
                        taskManager.filterAndDisplayTask();
                        break;
                    case 0:
                        System.out.println("EXITING...");
                        break;
                    default:
                        throw new TaskNotFoundException("Something went Wrong");
                }
            } catch (TaskNotFoundException e) {
                System.out.println("Enter within range!");
                ;
            }
        }
            while (choice!=0);
    }
}