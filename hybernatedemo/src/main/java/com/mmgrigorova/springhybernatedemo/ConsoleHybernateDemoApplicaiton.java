package com.mmgrigorova.springhybernatedemo;

import com.mmgrigorova.springhybernatedemo.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class ConsoleHybernateDemoApplicaiton {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hybernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        System.out.println("App started!!!");

    }
}
