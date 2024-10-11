package com.example.clase7gtics.repository;

import com.example.clase7gtics.entity.Funcion;
import com.example.clase7gtics.entity.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer> {

}

