package com.company;
import com.company.controller.EmployeeController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.EmployeeRepositories;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEmployeeRepositories repo = new EmployeeRepositories(db);
        EmployeeController controller = new EmployeeController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}