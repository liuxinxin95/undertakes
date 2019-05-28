package com.example.undertakes.service.impl;

import com.example.undertakes.UndertakesApplication;
import com.example.undertakes.entity.BlobField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={UndertakesApplication.class})
public class CustomUserServiceTest {

    @Autowired
    private CustomUserService customUserService;

    @Test
    public void findList() {
        List<BlobField> list = customUserService.findList();
        System.out.println(list.toArray().toString());


    }


}