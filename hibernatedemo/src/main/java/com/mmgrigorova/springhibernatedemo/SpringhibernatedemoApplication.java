package com.mmgrigorova.springhibernatedemo;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.mmgrigorova.springhibernatedemo.models.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//@org.springframework.context.annotation.Configuration
@SpringBootApplication
public class SpringhibernatedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringhibernatedemoApplication.class, args);
    }


}
