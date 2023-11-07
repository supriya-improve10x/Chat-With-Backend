package com.example.mysql.pakegestar;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AddDatabase {

//    @PostMapping(value = "addStudent", produces = MediaType.APPLICATION_JSON_VALUE)
//    public void addStudentsList(@RequestBody List<Student> student){
//        List<Student> addData = new ArrayList<>();
//        addData.addAll(student);
//    }

    @PostMapping(value = "addStudent", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudentList(@RequestBody List<Student> students)  {
        List<Student> studentList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String userName = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("INSERT into student(first_name, last_name) values ('supriya', 'singamsetty')");
            while (resultSet.next()) {
                Student student = new Student();
                student.firstname = resultSet.getString(2);
                student.lastName = resultSet.getString(3);
                student.dateOfBirth = resultSet.getString(4);
                student.emailId = resultSet.getString(5);
                student.major = resultSet.getString(6);
                student.graduationyear = resultSet.getString(7);
                studentList.add(student);
            }
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return studentList;
    }
}
