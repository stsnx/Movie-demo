package com.movie.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.demo.model.CustomReserveEntity;

@SpringBootTest
public class CustomServiceTest {
    @Autowired
    private CustomService customService;
    @Test
    public void showAvilableSeat(){
        ArrayList<CustomReserveEntity> unReserved = new ArrayList<>();
        unReserved.add(new CustomReserveEntity(1,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"A",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"B",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"B",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"B",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"B",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"B",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"C",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"D",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"E",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"F",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"G",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"H",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"I",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(1,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(2,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(3,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(4,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(5,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(6,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(7,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(8,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(9,"J",Long.valueOf(123)));
        unReserved.add(new CustomReserveEntity(10,"J",Long.valueOf(123)));
        assertEquals(unReserved, customService.findUnreserveById(Long.valueOf(123)));
    }
}
