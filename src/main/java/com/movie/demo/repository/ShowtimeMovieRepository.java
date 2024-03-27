package com.movie.demo.repository;

import com.movie.demo.model.ShowtimeMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.movie.demo.model.ShowTimeQueryEntity;
public interface ShowtimeMovieRepository extends JpaRepository<ShowtimeMovieEntity,Long> {

    @Query (value = "SELECT movie_show_time.movie_id, movie_show_time.`datetime`,movie_table.movie_name, theator_table.theator_name " +
            "FROM ((movie_show_time INNER JOIN movie_table ON movie_show_time.movie_id=:movId and movie_table.movie_id =:movId) "+
            "INNER JOIN theator_table ON theator_table.theator_id=movie_show_time.theator_id ) "+
            "ORDER BY datetime DESC;",nativeQuery = true)
    List<ShowTimeQueryEntity> findByMovieId(@Param("movId") Long movId);
}