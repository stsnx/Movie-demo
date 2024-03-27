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
@Table(name = "theator_table")
@NoArgsConstructor
@AllArgsConstructor
public class TheatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theator_id;
    @Column(name="theator_name")
    private String theator_name;

}