package com.movie.demo.model;

import java.time.LocalDateTime;


public interface ShowTimeQueryEntity {
    Long getMovie_id();
    String getMovie_Name();
    String getTheator_Name();
    LocalDateTime getDatetime();
}

