package com.movie.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "customer_reserve")
@NoArgsConstructor
@AllArgsConstructor
public class CustomReserveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "`row`")
    private String row;

    @Column (name = "`col`")
    private int col;

    @Column (name = "show_time_id")
    private Long show_time_id;
    
    public int getCol(){
        return this.col;
    }

    public String getRow(){
        return this.row;
    }

    public CustomReserveEntity(int col,String row,Long show_time_id ){
        this.col = col;
        this.row = row;
        this.show_time_id = show_time_id;
    }
}
