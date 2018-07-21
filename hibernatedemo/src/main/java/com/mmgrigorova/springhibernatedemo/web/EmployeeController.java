package com.mmgrigorova.springhibernatedemo.web;

import com.mmgrigorova.springhibernatedemo.models.Employee;
import com.mmgrigorova.springhibernatedemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler
    ResponseEntity<EmployeeError> handlerException(Exception e) {
        return new ResponseEntity<>(
                new EmployeeError(HttpStatus.BAD_REQUEST.value(), "Unable to Parse Id"),
                HttpStatus.BAD_REQUEST);
    }
}
