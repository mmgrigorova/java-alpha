package com.mmgrigorova.springhibernatedemo.data;

import com.mmgrigorova.springhibernatedemo.models.Address;
import com.mmgrigorova.springhibernatedemo.models.Employee;
import com.mmgrigorova.springhibernatedemo.models.Project;
import com.mmgrigorova.springhibernatedemo.models.Town;

import java.util.List;

public interface EmployeeRepository {
    Employee getById(int id);
    List<Employee> getAll();
    boolean addEmployee(Employee employee);
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);

    boolean addTown(Town town);
    List<Address> getAllAddresses();
    void addAddress(Address address);

     List<Project> getAllProjects();
}
