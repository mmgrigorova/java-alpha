package com.mmgrigorova.springhybernatedemo.data;

import com.mmgrigorova.springhybernatedemo.models.Address;
import com.mmgrigorova.springhybernatedemo.models.Employee;
import com.mmgrigorova.springhybernatedemo.models.Project;
import com.mmgrigorova.springhybernatedemo.models.Town;
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


}
