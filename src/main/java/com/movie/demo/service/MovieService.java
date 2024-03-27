package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.ClassRequest;
import com.movie.demo.model.MovieEntity;
import com.movie.demo.repository.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    public MovieEntity addMovie(MovieEntity movieEntity){
        return movieRepository.save(movieEntity);
    }
    public List<MovieEntity> getAllMovie(){
        return movieRepository.findAll();
    } 
    public String changeNameMovie(Long movie_id, ClassRequest.ChangeNameRequest changeNameRequest){
        if (movieRepository.existsById(movie_id)){
            MovieEntity existingMovie = movieRepository.findById(movie_id).orElse(null);
            String oldName = existingMovie.getMovie_name();
            existingMovie.setMovie_name(changeNameRequest.name);
            movieRepository.save(existingMovie);
            return String.format("Change name from %1$s to %2$s successfully.", oldName,changeNameRequest.name);
        }
        return "Your movie dosn't exist";
    }
}
