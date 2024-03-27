package com.movie.demo.repository;

import com.movie.demo.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Long>{
    
}

