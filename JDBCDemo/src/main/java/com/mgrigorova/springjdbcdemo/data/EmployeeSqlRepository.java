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
    private static final String CONFIG_FILE = "/Users/Maria/repos/java-alpha/JDBCDemo/src/main/resources/application.properties";
    private String dbUrl;
    private String dbUser;
    private String dbPass;

    public EmployeeSqlRepository() {
        dbUrl = dbUser = dbPass = "";
    }


    @Override
    public List<Employee> getAll() {

        loadDbConfig();

        List<Employee> employeesList = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                Statement statement = connection.createStatement();
        ) {
            System.out.println("Connection created.");
            String query = "select `FirstName`, `LastName`, `JobTitle` from employees;";
            ResultSet result = statement.executeQuery(query);

            readEmployeesData(employeesList, result);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed :( .");
        }

        return employeesList;
    }


    @Override
    public List<Employee> findByName(String name) {
        loadDbConfig();

        String query = "select `FirstName`, `LastName`, `JobTitle` " +
                "from employees " +
                "where firstname = ? ;";
        List<Employee> employeesList = new ArrayList<>();


        try (
                Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                PreparedStatement statement = connection.prepareStatement(query);

        ) {
            System.out.println("Connection created.");
            // set param for prepared statement
            statement.setString(1, name);

            ResultSet result = statement.executeQuery();
            readEmployeesData(employeesList, result);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed :( .");
        }

        return employeesList;
    }

    private void loadDbConfig() {
        Properties dbConfig = new Properties();

        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            dbConfig.load(fis);
        } catch (FileNotFoundException f) {
            System.out.println("Properties file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read properties file");
        }

        dbUrl = dbConfig.getProperty("dbUrl");
        dbUser = dbConfig.getProperty("dbUser");
        dbPass = dbConfig.getProperty("dbPass");
    }


    private void readEmployeesData(List<Employee> employeesList, ResultSet result) throws SQLException {
        while (result.next()) {
            Employee e = new Employee(
                    result.getString("FirstName"),
                    result.getString("LastName"),
                    result.getString("JobTitle")
            );

            employeesList.add(e);
        }
    }
}
