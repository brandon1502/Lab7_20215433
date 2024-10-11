package com.example.clase7gtics.repository;

import com.example.clase7gtics.entity.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {

}
