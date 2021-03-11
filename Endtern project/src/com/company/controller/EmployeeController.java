package com.company.controller;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepositories repo;

    public EmployeeController(IEmployeeRepositories repo){this.repo = repo;}
    public String hireEmployee(String name, String surname, String position, int salary){
        Employee employee = new Employee(name, surname, position, salary);
        boolean created = repo.hireEmployee(employee);
        return (created ? "Employee hired!" : "Employee was rejected!");
    }
    public String getEmployeeByID(int id){
        Employee employee = repo.getEmployeeByID(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }
    public String getAllEmployees(){
        List<Employee> employees = repo.getAllEmployee();
        return employees.toString();
    }
    public String fireEmployee(int id){
        boolean check = repo.fireEmployee(id);
        return (check ? "Employee was fired!" : "Employee by this id was not found!");
    }
    public String getEmployeeByPosition(String position){
        List<Employee> employees = repo.getEmployeeByPosition(position);
        return employees.toString();
    }
}
