package com.mmgrigorova.springhybernatedemo.services;

import com.mmgrigorova.springhybernatedemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(int id);
    List<Employee> getAll();
}
