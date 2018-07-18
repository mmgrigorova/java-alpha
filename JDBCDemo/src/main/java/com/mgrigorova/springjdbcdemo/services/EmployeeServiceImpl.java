package com.mgrigorova.springjdbcdemo.services;

import com.mgrigorova.springjdbcdemo.data.EmployeeRepository;
import com.mgrigorova.springjdbcdemo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }
}
