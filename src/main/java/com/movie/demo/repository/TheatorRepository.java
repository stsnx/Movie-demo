package com.movie.demo.repository;

import com.movie.demo.model.TheatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatorRepository extends JpaRepository<TheatorEntity,Long>{
    
}

