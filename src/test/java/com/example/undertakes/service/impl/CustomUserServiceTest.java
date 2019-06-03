package com.example.undertakes.service.impl;

import com.example.undertakes.UndertakesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={UndertakesApplication.class})
public class CustomUserServiceTest {

    @Autowired
    private CustomUserServiceImpl customUserService;

    @Test
    public void findList() {


    }


}