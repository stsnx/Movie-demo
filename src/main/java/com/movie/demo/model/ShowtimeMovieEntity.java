package com.movie.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "movie_show_time")


public class ShowtimeMovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="`datetime`")
    private LocalDateTime datetime;
    @Column(name="`movie_id`")
    private Long movie_id;
    @Column(name="`theator_id`")
    private Long theator_id;

    public LocalDateTime getDateTime(){
        return this.datetime;
    }
    public ShowtimeMovieEntity(){}
    public ShowtimeMovieEntity (Long id,LocalDateTime datetime, Long movie_id,Long theator_id){
        this.id = id;
        this.datetime = datetime;
        this.movie_id = movie_id;
        this.theator_id = theator_id;
    }
}
