package com.company.entities;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String position;
    private int salary;

    public Employee(){}
    public Employee(String name, String surname, String position, int salary){
        setName(name);
        setSurname(surname);
        setPosition(position);
        setSalary(salary);
    }
    public Employee(int id, String name, String surname, String position, int salary){
        setId(id);
        setName(name);
        setSurname(surname);
        setPosition(position);
        setSalary(salary);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
