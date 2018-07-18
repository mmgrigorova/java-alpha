package com.mgrigorova.springjdbcdemo.data;

import com.mgrigorova.springjdbcdemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll();
    List<Employee> findByName(String name);
}
