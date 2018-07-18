package com.mgrigorova.springjdbcdemo.web;

import java.util.*;

import com.mgrigorova.springjdbcdemo.data.EmployeeRepository;
import com.mgrigorova.springjdbcdemo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employees")
public class EmployeesRestController {
    private EmployeeRepository repository;

    @Autowired
    public EmployeesRestController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public List<Employee> getAll() {
        return repository.getAll();
    }
}
