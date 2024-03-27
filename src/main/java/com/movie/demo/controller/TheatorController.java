package com.movie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.ClassRequest;
import com.movie.demo.model.TheatorEntity;
import com.movie.demo.service.TheatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/theator")
public class TheatorController {

    @Autowired
    private TheatorService theatorService;

    @GetMapping("/getAllTheator")
    public List<TheatorEntity> getAll() {
        return theatorService.getAllTheators();
    }
    @PutMapping("/editName/{id}")
    public String changename (@PathVariable Long id, @RequestBody ClassRequest.ChangeNameRequest changeNameRequest){
        return theatorService.changeNameTheator(id, changeNameRequest);
    }
    @PostMapping("/addTheator")
    public String postDetail(@RequestBody TheatorEntity theatorEntity){
        theatorService.addTheator(theatorEntity);
        return "Add "+theatorEntity.getTheator_name()+" successfully.";
    }
    
    
}
