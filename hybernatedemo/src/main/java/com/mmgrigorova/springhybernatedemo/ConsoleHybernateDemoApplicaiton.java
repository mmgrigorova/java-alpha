package com.mmgrigorova.springhybernatedemo;

import com.mmgrigorova.springhybernatedemo.models.Address;
import com.mmgrigorova.springhybernatedemo.models.Employee;
import com.mmgrigorova.springhybernatedemo.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import java.util.List;

public class ConsoleHybernateDemoApplicaiton {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hybernate.cfg.xml")
                // Very important to add the entities in the setup
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .addAnnotatedClass(Address.class)
                // TODO research adding package
//                .addPackage("com.mmgrigorova.springhybernatedemo.models")
                .buildSessionFactory();



        System.out.println("App started!!!");

        /* Adding employee
        Employee newEmployee = new Employee("Petar", "Raykov", "Technical Trainer");

        session.save(newEmployee);
        session.getTransaction().commit();

        session.close();
        */

        Session session = factory.openSession();
//        Employee employee = session.get(Employee.class, 1);
//        System.out.println(
//                employee.getId() + ": " +
//                        employee.getFirstName() + " " +
//                        employee.getLastName() + " - " +
//                        employee.getJobTitle()
//        );
//        session.close();

        session = factory.openSession();
        session.beginTransaction();

//        Town town = new Town("Pleven");
////
//////        session.save(town);
////
////        session.getTransaction().commit();
////
////        Town myTown = session.get(Town.class, 37);
////        Town toDelete = session.get(Town.class, 36);
////
////        System.out.println(myTown);
////
////        session.delete(toDelete);
////
////        List<Town> towns = session.createQuery("FROM Town").list();
////
////        for (Town town1 : towns) {
////            System.out.println(town1);
////        }

        // Uni-directional one to one
        Employee e = session.get(Employee.class, 2);

        // Bi-directional one to one - just for test
        Address a = session.get(Address.class, 6);

        System.out.println(e);

        System.out.println(a.getEmployee());


        session.getTransaction().commit();
        session.close();


    }
}
