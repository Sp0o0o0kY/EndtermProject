package com.company;

import com.company.controller.EmployeeController;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MyApplication {
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(EmployeeController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("Welcome to My Application!");
            System.out.println("Select option: (1-5)");
            System.out.println("1. Get all Employees");
            System.out.println("2. Get Employees by id");
            System.out.println("3. Hire a Employee");
            System.out.println("4. Fire the Employee by id");
            System.out.println("5. Get Employee by Position");
            System.out.println("0. Exit");
            try {
                System.out.println("Enter the option: (1-5)");
                int option = scanner.nextByte();
                if (option == 1) {
                    getAllEmployees();
                } else if (option == 2) {
                    getEmployeeByID();
                } else if (option == 3) {
                    hireEmployee();
                } else if (option == 4) {
                    fireEmployee();
                } else if (option == 5) {
                    getEmployeeByPosition();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("************************************");
        }
    }
    public void getAllEmployees() {
        String response = controller.getAllEmployees();
        System.out.println(response);
    }
    public void getEmployeeByID() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getEmployeeByID(id);
        System.out.println(response);
    }
    public void hireEmployee() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter surname:");
        String surname = scanner.next();
        System.out.println("Please enter position:");
        String position = scanner.next();
        System.out.println("Please enter salary");
        int salary = scanner.nextInt();
        String response = controller.hireEmployee(name, surname, position, salary);
        System.out.println(response);
    }
    public void fireEmployee() {
        System.out.println("Please, enter the id of Employee that you want to fire:");
        int id = scanner.nextInt();
        controller.fireEmployee(id);
    }
    public void getEmployeeByPosition(){
        System.out.println("Please, enter Position");
        String position = scanner.next();
        String response = controller.getEmployeeByPosition(position);
        System.out.println(response);
    }
}

