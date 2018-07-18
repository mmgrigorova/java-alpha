package com.mgrigorova.springjdbcdemo.services;

import com.mgrigorova.springjdbcdemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    List<Employee> findByName(String name);

}
