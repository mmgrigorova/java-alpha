package com.mgrigorova.springjdbcdemo.web;

import java.util.*;

import com.mgrigorova.springjdbcdemo.models.Employee;
import com.mgrigorova.springjdbcdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
public class EmployeesRestController {
    private EmployeeService service;

    @Autowired
    public EmployeesRestController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @RequestMapping("/find/{name}")
    List<Employee> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }
}
