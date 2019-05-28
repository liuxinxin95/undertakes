package com.example.undertakes;

import com.example.undertakes.dao.BlobFielddDao;
import com.example.undertakes.entity.BlobField;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UndertakesApplicationTests {

    @Autowired
    private BlobFielddDao blobFielddDao;

    @Test
    public void contextLoads() {

        List<BlobField> list = blobFielddDao.findList();
        System.out.println(list);
    }

}
