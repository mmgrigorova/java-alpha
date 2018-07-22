package com.mmgrigorova.springhibernatedemo.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.mmgrigorova.springhibernatedemo.models.Address;
import com.mmgrigorova.springhibernatedemo.models.Employee;
import com.mmgrigorova.springhibernatedemo.models.Project;
import com.mmgrigorova.springhibernatedemo.models.Town;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public SessionFactory createSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                // Very important to add the entities in the setup
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Project.class)
                // TODO research adding package
//                .addPackage("com.mmgrigorova.springhibernatedemo.models")
                .buildSessionFactory();
    }

    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate4Module();
    }
}
