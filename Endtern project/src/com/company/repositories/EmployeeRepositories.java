package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepositories implements IEmployeeRepositories {
    private final IDB db;

    public EmployeeRepositories(IDB db) {
        this.db = db;
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO employee(name, surname, position, salary) VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getPosition());
            st.setInt(4, employee.getSalary());


            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, position, salary FROM employee WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("salary"));
                return employee;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, position, salary FROM employee";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employee = new LinkedList<>();
            while (rs.next()) {
                Employee employees = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("salary"));
                employee.add(employees);
            }
            return employee;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean fireEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        Connection con = null;
        try {
            con = db.getConnection();
            // String sql = "SELECT id, name, price, expiration_date, manufacturer FROM users WHERE manufacturer = ?";
            PreparedStatement st = con.prepareStatement("SELECT id, name, surname, position, salary FROM employee WHERE position = ?");
            st.setString(1, position);
            ResultSet rs = st.executeQuery();
            List<Employee> employees = new LinkedList<>();
            while(rs.next()){
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("salary"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
