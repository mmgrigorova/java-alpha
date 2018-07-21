package com.mmgrigorova.springhibernatedemo;

import com.mmgrigorova.springhibernatedemo.models.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
@SpringBootApplication
public class SpringhybernatedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringhybernatedemoApplication.class, args);
    }

    @Bean
    public SessionFactory createSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                // Very important to add the entities in the setup
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Project.class)
                // TODO research adding package
//                .addPackage("com.mmgrigorova.springhybernatedemo.models")
                .buildSessionFactory();
    }

}