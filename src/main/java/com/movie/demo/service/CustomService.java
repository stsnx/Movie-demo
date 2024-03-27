package com.movie.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.model.CustomReserveEntity;
import com.movie.demo.model.MovieEntity;
import com.movie.demo.model.ShowtimeMovieEntity;
import com.movie.demo.model.TheatorEntity;
import com.movie.demo.ClassRequest;
import com.movie.demo.repository.CustomReserveRepository;
import com.movie.demo.repository.MovieRepository;
import com.movie.demo.repository.ShowtimeMovieRepository;
import com.movie.demo.repository.TheatorRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomService {
    
    @Autowired
    private CustomReserveRepository customReserveRepository;
    @Autowired
    private ShowtimeMovieRepository showtimeMovieRepository;
    @Autowired
    private TheatorRepository theatorRepository;
    @Autowired
    private MovieRepository movieRepository;

    private static final Logger LOG = LoggerFactory.getLogger(CustomService.class);
    public String reserveSeat(ClassRequest.Reserve reserve){
        if (showtimeMovieRepository.existsById(reserve.id)){
            if(customReserveRepository.findSeat(reserve.id,Long.valueOf(reserve.col),reserve.row).size()==0){
                CustomReserveEntity customReserveEntity = new CustomReserveEntity(reserve.col,reserve.row,reserve.id);
                ShowtimeMovieEntity showtimeMovieEntity = showtimeMovieRepository.findById(reserve.id).orElse(null);
                if(reserve.col<1 || reserve.col>10){
                    return "Invalid seat position";
                }   
                else if((int)reserve.row.charAt(0)<65 || (int)reserve.row.charAt(0)>75){
                    return "Invalid seat position";
                }              
                else{
                String movName = "";
                String theatorName = "";
                if(showtimeMovieEntity!=null){
                    MovieEntity movieEntity =  movieRepository.findById(showtimeMovieEntity.getMovie_id()).orElse(null);
                    movName = movieEntity.getMovie_name();
                    TheatorEntity theatorEntity =theatorRepository.findById(showtimeMovieEntity.getTheator_id()).orElse(null);
                    theatorName = theatorEntity.getTheator_name();
                } 
                LOG.info("Reserve seat {} at {}, {}, {} successfully on {}",reserve.row+String.valueOf(reserve.col),movName,theatorName,showtimeMovieEntity.getDateTime().toString(), new Date());


                customReserveRepository.save(customReserveEntity);  
                return String.format("Reserve seat %1$s at %2$s, %3$s, %4$s successfully",reserve.row+String.valueOf(reserve.col),movName,theatorName,showtimeMovieEntity.getDateTime().toString(), new Date());
                }
            }
            else{
                return "Seat "+reserve.row+String.valueOf(reserve.col)+" has been reserved";
            }
        }
        else{
            return "This showtime doesn't exist";
        }
        
    }
    public String cancelReserveSeat(ClassRequest.Reserve reserve){
        if (showtimeMovieRepository.existsById(reserve.id)){
            if(customReserveRepository.findSeat(reserve.id,Long.valueOf(reserve.col),reserve.row).size()!=0){
                ShowtimeMovieEntity showtimeMovieEntity = showtimeMovieRepository.findById(reserve.id).orElse(null);
                if(reserve.col<1 || reserve.col>10){
                    return "Invalid seat position";
                }   
                else if((int)reserve.row.charAt(0)<65 || (int)reserve.row.charAt(0)>75){
                    return "Invalid seat position";
                }              
                else{
                String movName = "";
                String theatorName = "";
                if(showtimeMovieEntity!=null){
                    MovieEntity movieEntity =  movieRepository.findById(showtimeMovieEntity.getMovie_id()).orElse(null);
                    movName = movieEntity.getMovie_name();
                    TheatorEntity theatorEntity =theatorRepository.findById(showtimeMovieEntity.getTheator_id()).orElse(null);
                    theatorName = theatorEntity.getTheator_name();
                } 
                LOG.info("Seat {} at {}, {}, {} has been canceled on {}",reserve.row+String.valueOf(reserve.col),movName,theatorName,showtimeMovieEntity.getDateTime().toString(), new Date());
                customReserveRepository.delete(customReserveRepository.findSeat(reserve.id,Long.valueOf(reserve.col),reserve.row).get(0));  
                return String.format("Cancel reserve seat %1$s at %2$s, %3$s, %4$s successfully",reserve.row+String.valueOf(reserve.col),movName,theatorName,showtimeMovieEntity.getDateTime().toString(), new Date());
                }
            }
            else{
                return "Seat "+reserve.row+String.valueOf(reserve.col)+" hasn't reserved";
            }
        }
        else{
            return "This showtime doesn't exist";
        }
        
    }
    public List<CustomReserveEntity> findReserveById(Long showTimeId) {
        return customReserveRepository.findByMovieId(showTimeId);
    }
    public List<CustomReserveEntity> findUnreserveById(Long showTimeId) {
        int[][] arReserve = new int[10][10];
        ArrayList<CustomReserveEntity> listOfPairs = new ArrayList<>();
        List<CustomReserveEntity> reserves = customReserveRepository.findByMovieId(showTimeId);
        for (CustomReserveEntity reserve : reserves) {
            arReserve[Long.valueOf(reserve.getCol()).intValue()-1][(int)reserve.getRow().toUpperCase().charAt(0) - 65] = 1;
        }
        for (int j= 0 ;j<10 ;j++){
            for (int i= 0 ;i<10 ;i++){
                if(arReserve[i][j]==0){
                    
                    CustomReserveEntity seat = new CustomReserveEntity(i+1,Character.toString((char)(j+65)),showTimeId);
                    listOfPairs.add(seat);
                }

            }
        }
       
        return listOfPairs;
    }
}
