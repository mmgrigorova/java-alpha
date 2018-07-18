package com.mgrigorova.springjdbcdemo.data;

import com.mgrigorova.springjdbcdemo.models.Employee;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class EmployeeSqlRepository implements EmployeeRepository {

    @Override
    public List<Employee> getAll() {
        Properties dbConfig = new Properties();

        String configFilePath = "/Users/Maria/repos/java-alpha/JDBCDemo/src/main/resources/application.properties";

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

        List<Employee> employeesList = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                Statement statement = connection.createStatement();
        ) {
            System.out.println("Connection created.");
            String query = "select `FirstName`, `LastName`, `JobTitle` from employees;";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Employee e = new Employee(
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("JobTitle")
                );

                employeesList.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed :( .");
        }

        return employeesList;
    }
}
