package com.movie.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import com.movie.demo.model.CustomReserveEntity;
import com.movie.demo.model.ShowTimeQueryEntity;
import com.movie.demo.model.ShowtimeMovieEntity;
import com.movie.demo.repository.ShowtimeMovieRepository;

@SpringBootTest

public class ShowtimeMovieServiceAddTest {
    @Autowired
    private ShowtimeMovieService showtimeMovieService;
    @MockBean
    private ShowtimeMovieRepository showtimeMovieRepository;
    
    @Test
    public void addShowtimeMovieSuccess(){
        
        LocalDateTime dateTime = LocalDateTime.of(2018, 2, 14, 14, 00);  
        Long movie_id = Long.valueOf(1234);
        Long theator_id = Long.valueOf(1234);
        ShowtimeMovieEntity showtimeMovieEntity = new ShowtimeMovieEntity(null,dateTime, movie_id, theator_id);
        assertEquals("Showtime earthtiphoom 2018-02-14T14:00 at xearthx has been added successfully", showtimeMovieService.addShowtimeMovie(showtimeMovieEntity) );
    }
}

