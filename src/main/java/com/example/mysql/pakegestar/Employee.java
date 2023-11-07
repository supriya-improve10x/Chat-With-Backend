package com.example.mysql.pakegestar;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Employee {
    public int employeeId;
    public String firstname;
    public int salary;

    @GetMapping(value = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeeNames() {
        List<Employee> employee = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee  order by first_name");
            while (resultSet.next()) {
                Employee employee1 = new Employee();
                employee1.employeeId = resultSet.getInt(1);
                employee1.firstname = resultSet.getString(2);
                employee.add(employee1);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
