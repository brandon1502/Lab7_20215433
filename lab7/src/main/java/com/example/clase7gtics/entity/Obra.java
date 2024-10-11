package com.example.clase7gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "obras")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="description")
    private String descripcion;

    @Column(name="duration",nullable = false)
    private int duracion;

    @Column(name="releaseDate",nullable = false)
    private Date releaseDate;
}

