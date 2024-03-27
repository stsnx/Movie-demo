package com.movie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.model.ShowtimeMovieEntity;
import com.movie.demo.model.ShowTimeQueryEntity;
import com.movie.demo.service.ShowtimeMovieService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@RestController
@RequestMapping("/showtime")
public class ShowtimeMovieController {

    @Autowired
    private ShowtimeMovieService showtimeMovieService;

    @PostMapping("/addShowtime")
    public String saveEntity(@RequestBody ShowtimeMovieEntity showtimeMovieEntity) {
        return showtimeMovieService.addShowtimeMovie(showtimeMovieEntity);
    
    }
    @PostMapping("/findByMovieId/{id}")
    public List<ShowTimeQueryEntity> findMoviebyId(@PathVariable Long id) {
        return showtimeMovieService.findMovieById(id);
        
    }
}
