package com.mmgrigorova.springhybernatedemo;

import com.mmgrigorova.springhibernatedemo.data.EmployeeRepository;
import com.mmgrigorova.springhibernatedemo.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringhybernatedemoApplicationTests {
    @Mock
    private EmployeeRepository repository;

    private EmployeeService service;

    @Test
    public void getById_WhenValidID_AndEmployeeIsPresent_ReturnEmployee(){}

    @Test
    public void contextLoads() {

    }

}
