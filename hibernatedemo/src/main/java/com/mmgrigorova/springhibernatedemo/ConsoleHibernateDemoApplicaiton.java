package com.mmgrigorova.springhibernatedemo;

import com.mmgrigorova.springhibernatedemo.models.Address;
import com.mmgrigorova.springhibernatedemo.models.Employee;
import com.mmgrigorova.springhibernatedemo.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class ConsoleHybernateDemoApplicaiton {
    public static void mainDeprecated(String[] args) {


        SessionFactory factory = null;

        System.out.println("App started!!!");

        /* Adding employee
        Employee newEmployee = new Employee("Petar", "Raykov", "Technical Trainer");

        session.save(newEmployee);
        session.getTransaction().commit();

        session.close();
        */

        Session session = factory.openSession();
        Employee employee = session.get(Employee.class, 1);
        System.out.println(
                employee.getId() + ": " +
                        employee.getFirstName() + " " +
                        employee.getLastName() + " - " +
                        employee.getJobTitle()
        );
        session.close();

        session = factory.openSession();
        session.beginTransaction();

        Town town = new Town("Pleven");

//        session.save(town);

        session.getTransaction().commit();

        Town myTown = session.get(Town.class, 37);
        Town toDelete = session.get(Town.class, 36);

        System.out.println(myTown);

        session.delete(toDelete);

        List<Town> towns = session.createQuery("FROM Town").list();

        for (Town town1 : towns) {
            System.out.println(town1);
        }

        // Uni-directional one to one
        Employee employee2 = session.get(Employee.class, 2);

        // Bi-directional one to one - just for test
        Address a = session.get(Address.class, 6);

        System.out.println(employee2);

//        System.out.println(a.getEmployee());

//        Town t = session.get(Town.class, 32);
//        t.getAddresses().add(new Address("Alexander Malinov 31"));

//        session.save(t);
//
//        System.out.println(t);
//
//        for (Address address : t.getAddresses()) {
//            System.out.println(address.getEmployee());
//        }

        Address a2 = session.get(Address.class, 292);

//        System.out.println(a2 + " " + a2.getTown());

        Town t2 = session.get(Town.class, 32);
        System.out.println(t2);
//        for (Address address : t2.getAddresses()) {
//            System.out.println(address);
//        }


        Employee emp = session.get(Employee.class, 3);

        System.out.println(emp.getFirstName());
        // Get projects by employee
//        for (Project project : emp.getProjects()) {
//            System.out.println(project);
//        }

        //Get employees by project
//        Project p = session.get(Project.class, 2);
//        System.out.println(p);
//        for (Employee employee1 : p.getEmployees()) {
//            System.out.println(employee1);
//        }

        session.getTransaction().commit();
        session.close();


    }
}
