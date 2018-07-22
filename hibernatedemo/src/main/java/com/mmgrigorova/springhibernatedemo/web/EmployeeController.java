package com.mmgrigorova.springhibernatedemo.web;

import com.mmgrigorova.springhibernatedemo.models.Employee;
import com.mmgrigorova.springhibernatedemo.models.Town;
import com.mmgrigorova.springhibernatedemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

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

    // TODO Fix Adding employee
    @PostMapping("/add/")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }


    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable("id") String idString, @RequestBody Employee employee){
        int id = Integer.parseInt(idString);
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") String idString){
        int id = Integer.parseInt(idString);
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/town/")
    public void addTown(Town town){
        employeeService.addTown(town);
    }

//    @ExceptionHandler
//    ResponseEntity<EmployeeError> handlerException(Exception e) {
//        return new ResponseEntity<>(
//                new EmployeeError(HttpStatus.BAD_REQUEST.value(), "Unable to Parse Id"),
//                HttpStatus.BAD_REQUEST);
//    }
}
