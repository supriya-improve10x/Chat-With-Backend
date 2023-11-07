package com.example.mysql.pakegestar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Students {

    public String firstname;

    @GetMapping(value = "students/firstname",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getStudentsDetails(@RequestParam("firstname") String firstName){
        List<String> studentsDetails = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  student WHERE first_name ="+firstName+"" );
            while (resultSet.next()) {
                String firstname = resultSet.getString(2) ;
                studentsDetails.add(firstname);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentsDetails;
    }
}
