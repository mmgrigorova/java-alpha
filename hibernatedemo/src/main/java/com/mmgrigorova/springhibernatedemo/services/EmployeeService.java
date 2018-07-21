package com.mmgrigorova.springhibernatedemo.services;

import com.mmgrigorova.springhibernatedemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(int id);
    List<Employee> getAll();
}
