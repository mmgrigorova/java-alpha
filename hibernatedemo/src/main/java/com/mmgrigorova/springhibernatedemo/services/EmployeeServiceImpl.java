package com.mmgrigorova.springhibernatedemo.services;

import com.mmgrigorova.springhibernatedemo.data.EmployeeRepository;
import com.mmgrigorova.springhibernatedemo.models.Employee;
import com.mmgrigorova.springhibernatedemo.models.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
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

    // TODO Fix Adding employee
    @Override
    public boolean addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        employeeRepository.updateEmployee(id, employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean addTown(Town town) {
        return employeeRepository.addTown(town);
    }
}
