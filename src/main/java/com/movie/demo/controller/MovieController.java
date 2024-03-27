package com.movie.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.ClassRequest;
import com.movie.demo.model.MovieEntity;
import com.movie.demo.service.MovieService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getAllMovie")
    public List<MovieEntity> getAll() {
        return movieService.getAllMovie();
    }
    @PutMapping("/editName/{id}")
    public String changename (@PathVariable Long id, @RequestBody ClassRequest.ChangeNameRequest changeNameRequest){
        return movieService.changeNameMovie(id, changeNameRequest);
    }
    @PostMapping("/addMovie")
    public String postDetail(@RequestBody MovieEntity movieEntity){
        movieService.addMovie(movieEntity);
        return "Add "+movieEntity.getMovie_name()+" successfully.";
    }
    
    
}
