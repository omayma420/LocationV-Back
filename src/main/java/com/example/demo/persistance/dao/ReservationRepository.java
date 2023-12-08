package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Reservation; 

public interface ReservationRepository extends JpaRepository<Reservation, Long> { 

    @Query(value = "select count(*) from reservation", nativeQuery = true) 
    int getQuantityOfReservation(); 

    @Query(value = "select * from reservation where id= :id", nativeQuery = true) 
    Reservation getReservationByIdReservation(@Param("id") Long id); 
}

