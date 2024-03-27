package com.movie.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.model.CustomReserveEntity;
import com.movie.demo.service.CustomService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.movie.demo.ClassRequest;

@RestController
@RequestMapping("/customer")
public class CustomReserveController {

    @Autowired
    private CustomService customService;
    
    @PostMapping("/reserve")
    public String reserveSeat(@RequestBody ClassRequest.Reserve reserve){
        return customService.reserveSeat(reserve);
    }
    @PostMapping("/cancelReserve")
    public String cancelReserveSeat(@RequestBody ClassRequest.Reserve reserve){
        return customService.cancelReserveSeat(reserve);
    }
    @PostMapping("/findReserveById/{id}")
    public List<CustomReserveEntity> findReserveById(@PathVariable Long id){
        
        return customService.findReserveById(id);
    }
    @PostMapping("/findUnreserveById/{id}")
    public List<CustomReserveEntity> findUnreserveById(@PathVariable Long id){
        
        return customService.findUnreserveById(id);
    }
}
