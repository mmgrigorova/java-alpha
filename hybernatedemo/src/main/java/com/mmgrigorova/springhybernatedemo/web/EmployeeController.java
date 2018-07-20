package com.mmgrigorova.springhybernatedemo.web;

import com.mmgrigorova.springhybernatedemo.models.Employee;
import com.mmgrigorova.springhybernatedemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getById(int id){
       return employeeService.getById(id);
    }

    public List<Employee> getAll(){
       return employeeService.getAll();
    }
}
