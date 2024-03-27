package com.movie.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.model.MovieEntity;
import com.movie.demo.model.ShowTimeQueryEntity;
import com.movie.demo.model.ShowtimeMovieEntity;
import com.movie.demo.model.TheatorEntity;
import com.movie.demo.repository.MovieRepository;
import com.movie.demo.repository.ShowtimeMovieRepository;
import com.movie.demo.repository.TheatorRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

@Service
public class ShowtimeMovieService {
    
    @Autowired
    private ShowtimeMovieRepository showtimeMovieRepository;
    @Autowired
    private TheatorRepository theatorRepository;
    @Autowired
    private MovieRepository movieRepository;

    public String addShowtimeMovie(ShowtimeMovieEntity showtimeMovieEntity){
        LocalDateTime showTime = LocalDateTime.parse(showtimeMovieEntity.getDateTime().toString(), DateTimeFormatter.ISO_DATE_TIME);
        
        if((showTime.getHour()==11 && showTime.getMinute()==0) || (showTime.getHour()==14 && showTime.getMinute()==0) || (showTime.getHour()==17 && showTime.getMinute()==0) || (showTime.getHour()==20 && showTime.getMinute()==0) ){
            if(movieRepository.existsById(showtimeMovieEntity.getMovie_id())&&theatorRepository.existsById(showtimeMovieEntity.getTheator_id())){
                try {
                showtimeMovieRepository.save(showtimeMovieEntity);  
                MovieEntity movieEntity =  movieRepository.findById(showtimeMovieEntity.getMovie_id()).orElse(null);
                String movName = movieEntity.getMovie_name();
                TheatorEntity theatorEntity =theatorRepository.findById(showtimeMovieEntity.getTheator_id()).orElse(null);
                String theatorName = theatorEntity.getTheator_name();
                return String.format("Showtime %2$s %1$s at %3$s has been added successfully" ,showtimeMovieEntity.getDateTime(),movName,theatorName);
                }
                catch(Exception e ){
                   if(StringUtils.containsIgnoreCase(e.getMessage(), "Duplicate entry")){
                        return "This showtime existed already.";
                   }
                   return e.getMessage();
                }
            }
            else{
                return "Invalid Theator or Movie";
            }
            
        } else{
            return "Invalid time";
        }
    }
    public List<ShowTimeQueryEntity> findMovieById(Long movId) {
        return showtimeMovieRepository.findByMovieId(movId);
    }
    

}
