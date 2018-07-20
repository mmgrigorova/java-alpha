package com.mmgrigorova.springhybernatedemo.services;

import com.mmgrigorova.springhybernatedemo.data.EmployeeRepository;
import com.mmgrigorova.springhybernatedemo.models.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
