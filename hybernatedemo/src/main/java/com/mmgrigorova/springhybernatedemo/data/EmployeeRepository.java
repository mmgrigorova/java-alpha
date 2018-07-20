package com.mmgrigorova.springhybernatedemo.data;

import com.mmgrigorova.springhybernatedemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getById(int id);
    List<Employee> getAll();
}
