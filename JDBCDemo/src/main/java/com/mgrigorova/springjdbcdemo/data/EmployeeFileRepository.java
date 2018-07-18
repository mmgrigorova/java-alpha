package com.mgrigorova.springjdbcdemo.data;

import com.mgrigorova.springjdbcdemo.models.Employee;

import java.util.List;

public class EmployeeFileRepository implements EmployeeRepository {

    @Override
    public List<Employee> getAll() {
        // read employee data from file
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }
}
