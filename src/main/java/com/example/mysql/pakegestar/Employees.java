package com.example.mysql.pakegestar;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Employees {

    @GetMapping(value = "list/salary", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getEmployeeNames(@RequestParam("salary") int salary) {
        List<Integer> employees = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *  FROM employee WHERE salary =" +salary);
            while (resultSet.next()) {
               int employeeId = resultSet.getInt(1);
               employees.add(employeeId);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
