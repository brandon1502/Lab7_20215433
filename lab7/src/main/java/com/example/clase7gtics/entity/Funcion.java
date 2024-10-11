package com.example.clase7gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "funciones")
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "obraId")
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;


    @Column(name="funcionDate",nullable = false)
    private Date funcionDate;

    @Column(name="availableseats")
    private int availableSeats;
}
