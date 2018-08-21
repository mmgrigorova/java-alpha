package com.mmgrigorova.springhibernatedemo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.deploy.security.ValidationState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "JobTitle")
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "DepartmentId")
    private Department department;

    @OneToMany(mappedBy = "departmentManager")
    private List<Department> managedDepartment;

    @ManyToOne
    @JoinColumn(name = "AddressId")
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "employeesprojects",
            joinColumns = @JoinColumn(name = "EmployeeId"),
            inverseJoinColumns = @JoinColumn(name = "ProjectId")
    )
    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();


    public Employee() {

    }

    public Employee(String firstName, String lastName, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void mergeEmployeeData(Employee employee) {
        if (employee.firstName != null && !employee.firstName.equals("")) {
            setFirstName(employee.firstName);
        }
        if (employee.lastName != null && !employee.lastName.equals("")) {
            setLastName(employee.lastName);
        }

        if (employee.jobTitle != null && !employee.jobTitle.equals("")) {
            setJobTitle(employee.jobTitle);
        }

        if (employee.address != null) {
            setAddress(employee.address);
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(List<Department> managedDepartment) {
        this.managedDepartment = managedDepartment;
    }

    @Override
    public String toString() {
        return String.format("Employee id %d: %s %s, address: %s", id, firstName, lastName, address);
    }
}
