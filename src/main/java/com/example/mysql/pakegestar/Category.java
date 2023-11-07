package com.example.mysql.pakegestar;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Category {
    public String name;

    @GetMapping(value = "names", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getCategoryList() {
        List<String> categoryNames = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String userName = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Categories");
            while (resultSet.next()) {
               String name = resultSet.getString(1);
                categoryNames.add(name);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryNames;
    }
}
