package com.mmgrigorova.springhibernatedemo.data;

import com.mmgrigorova.springhibernatedemo.models.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeSQLRepositoryImpl implements EmployeeRepository {
    private static SessionFactory factory;

    @Autowired
    public EmployeeSQLRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            employee.getProjects().size();
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        try(Session session = factory.openSession()){
            session.beginTransaction();
            employees = session.createQuery("FROM Employee AS e").list();
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    // TODO Fix adding employee
    @Override
    public boolean addEmployee(Employee employee) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateEmployee(int id) {

    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public boolean addTown(Town town) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(town);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
