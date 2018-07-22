package com.mmgrigorova.springhibernatedemo.services;

import com.mmgrigorova.springhibernatedemo.models.Employee;
import com.mmgrigorova.springhibernatedemo.models.Town;

import java.util.List;

public interface EmployeeService {
    Employee getById(int id);
    List<Employee> getAll();
    boolean addEmployee(Employee employee);
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);

    boolean addTown(Town town);
}
