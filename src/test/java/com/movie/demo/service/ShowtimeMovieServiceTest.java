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

public class ShowtimeMovieServiceTest {
    @Autowired
    private ShowtimeMovieService showtimeMovieService;
    @Test
    public void testGetByIDExist1(){
        List<ShowTimeQueryEntity> showtimeMovieEntity = showtimeMovieService.findMovieById(Long.valueOf(1234));
        org.junit.jupiter.api.Assertions.assertFalse(showtimeMovieEntity.isEmpty());
    }
    @Test
    public void testGetByIDExist2(){
        List<ShowTimeQueryEntity> showtimeMovieEntity = showtimeMovieService.findMovieById(Long.valueOf(1235));
        org.junit.jupiter.api.Assertions.assertFalse(showtimeMovieEntity.isEmpty());

    }
    @Test
    public void testGetByIDNotExist(){
        List<ShowTimeQueryEntity> showtimeMovieEntity = showtimeMovieService.findMovieById(Long.valueOf(5235));
        org.junit.jupiter.api.Assertions.assertTrue(showtimeMovieEntity.isEmpty());
    }
 
    @Test
    public void addShowtimeMovieIsalreadyExisted(){
        LocalDateTime dateTime = LocalDateTime.of(2017, 2, 14, 14, 00);  
        Long movie_id = Long.valueOf(1234);
        Long theator_id = Long.valueOf(1234);
        ShowtimeMovieEntity showtimeMovieEntity = new ShowtimeMovieEntity(null,dateTime, movie_id, theator_id);
        assertEquals("This showtime existed already.", showtimeMovieService.addShowtimeMovie(showtimeMovieEntity) );
    }
    @Test
    public void addShowtimeInvalidTheator(){
        LocalDateTime dateTime = LocalDateTime.of(2017, 1, 15, 14, 00);  
        Long movie_id = Long.valueOf(1234);
        Long theator_id = Long.valueOf(4234);
        ShowtimeMovieEntity showtimeMovieEntity = new ShowtimeMovieEntity(null,dateTime, movie_id, theator_id);
        assertEquals("Invalid Theator or Movie", showtimeMovieService.addShowtimeMovie(showtimeMovieEntity) );
    }
    @Test
    public void addShowtimeInvalidMovie(){
        LocalDateTime dateTime = LocalDateTime.of(2017, 1, 15, 14, 00);  
        Long movie_id = Long.valueOf(4234);
        Long theator_id = Long.valueOf(1234);
        ShowtimeMovieEntity showtimeMovieEntity = new ShowtimeMovieEntity(null,dateTime, movie_id, theator_id);
        assertEquals("Invalid Theator or Movie", showtimeMovieService.addShowtimeMovie(showtimeMovieEntity) );
    }
    @Test
    public void addShowtimeInvalidTime1(){
        LocalDateTime dateTime = LocalDateTime.of(2017, 1, 15, 10, 00);  
        Long movie_id = Long.valueOf(4234);
        Long theator_id = Long.valueOf(1234);
        ShowtimeMovieEntity showtimeMovieEntity = new ShowtimeMovieEntity(null,dateTime, movie_id, theator_id);
        assertEquals("Invalid time", showtimeMovieService.addShowtimeMovie(showtimeMovieEntity) );
    }
    @Test
    public void addShowtimeInvalidTime2(){
        LocalDateTime dateTime = LocalDateTime.of(2017, 1, 15, 14, 10);  
        Long movie_id = Long.valueOf(4234);
        Long theator_id = Long.valueOf(1234);
        ShowtimeMovieEntity showtimeMovieEntity = new ShowtimeMovieEntity(null,dateTime, movie_id, theator_id);
        assertEquals("Invalid time", showtimeMovieService.addShowtimeMovie(showtimeMovieEntity) );
    }
    
}

