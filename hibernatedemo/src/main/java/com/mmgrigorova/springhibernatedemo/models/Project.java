package com.mmgrigorova.springhibernatedemo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private int id;

    @Column(name = "Description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employeesprojects",
            joinColumns = @JoinColumn(name = "ProjectId"),
            inverseJoinColumns = @JoinColumn(name = "EmployeeId")
    )
    @JsonBackReference
    private List<Employee> employees = new ArrayList<>();

    public Project() {
    }

    public Project(String description) {
        this.description = description;
        employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return id + " " + description;
    }
}
