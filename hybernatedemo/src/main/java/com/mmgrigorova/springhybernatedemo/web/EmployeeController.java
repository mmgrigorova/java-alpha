package com.mmgrigorova.springhybernatedemo.web;

import com.mmgrigorova.springhybernatedemo.models.Employee;
import com.mmgrigorova.springhybernatedemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") String idString) {
        int id = Integer.parseInt(idString);
        return employeeService.getById(id);
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
