package com.company.repositories.interfaces;

import com.company.entities.Employee;

import java.util.List;

public interface IEmployeeRepositories {
    boolean hireEmployee(Employee employee);
    Employee getEmployeeByID(int id);
    List<Employee> getAllEmployee();
    boolean fireEmployee(int id);
    List<Employee> getEmployeeByPosition(String position);

}