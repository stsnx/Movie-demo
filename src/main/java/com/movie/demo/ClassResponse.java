package com.movie.demo;

import java.time.LocalDateTime;



public class ClassResponse {
    public class ShowTimeQueryEntity {

    private Long movie_id;
    private LocalDateTime Datetime;
    private String movie_name;
    private String theator_name;

    public Long getMovie_Id(){
        return this.movie_id;
    }
    public LocalDateTime getDatetime(){
        return this.Datetime;
    }
    public String getMovie_Name(){
        return this.movie_name;
    }
    public String getTheator_Name(){
        return this.theator_name;
    }
    public ShowTimeQueryEntity(Long movie_id,LocalDateTime Datetime,String movie_name,String theator_name){
        this.movie_id = movie_id;
        this.Datetime = Datetime;
        this.movie_name = movie_name;
        this.theator_name = theator_name;

    }
}

}
