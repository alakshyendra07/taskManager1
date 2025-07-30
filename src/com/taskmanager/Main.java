package com.taskmanager;

import com.taskmanager.exception.TaskNotFoundException;
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
                        taskManager.addTask();
                        break;

                    case 2:
                        taskManager.viewTask();
                        break;
                    case 3:
                        taskManager.markTaskAsDone();
                        break;
                    case 4:
                        taskManager.deleteTask();
                        break;
                    case 5:
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