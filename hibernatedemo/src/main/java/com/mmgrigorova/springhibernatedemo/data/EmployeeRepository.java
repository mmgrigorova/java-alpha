package com.mmgrigorova.springhibernatedemo.data;

import com.mmgrigorova.springhibernatedemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getById(int id);
    List<Employee> getAll();
    Employee addEmployee(Employee employee);
    void updateEmployee(int id);
    void deleteEmployee(int id);
}
