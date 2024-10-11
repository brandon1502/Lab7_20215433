package com.example.clase7gtics.repository;

import com.example.clase7gtics.entity.Obra;
import com.example.clase7gtics.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
