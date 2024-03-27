package com.movie.demo.repository;

import com.movie.demo.model.CustomReserveEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomReserveRepository extends JpaRepository<CustomReserveEntity,Long>{
    @Query (value = "SELECT * FROM customer_reserve "+
    "WHERE show_time_id=:showTimeId",nativeQuery = true)
    List<CustomReserveEntity> findByMovieId(@Param("showTimeId") Long showTimeId);
    @Query(value = "SELECT * FROM customer_reserve WHERE customer_reserve.`col` = :col AND customer_reserve.`row` = :row AND customer_reserve.show_time_id = :showTimeId" ,nativeQuery = true)
    List<CustomReserveEntity> findSeat(Long showTimeId,Long col, String row);
}
