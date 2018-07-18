package com.mgrigorova.springjdbcdemo.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeesRestController {

    @RequestMapping("/")
    void getAll() {
        Properties dbConfig = new Properties();

        String configFilePath = "src\\main\\resources\\application.properties";

        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            dbConfig.load(fis);
        } catch (FileNotFoundException f) {
            System.out.println("Properties file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read properties file");
        }

        String dbUrl = dbConfig.getProperty("dbUrl");
        String dbUser = dbConfig.getProperty("dbUser");
        String dbPass = dbConfig.getProperty("dbPass");

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            System.out.println("Connection created.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed :( .");
        }

    }
}
