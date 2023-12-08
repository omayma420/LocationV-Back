package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.persistance.entities.Reservation; 

public interface IReservation { 

    Reservation saveReservation(Reservation reservation); 
    Reservation updateReservation(Reservation reservation); 
    boolean deleteReservation(Long id); 
    List<Reservation> getListReservation(); 
    Reservation getReservation(Long id);  
    int getQuantityOfReservation(); 
    Reservation getReservationByIdReservation(Long id); 
}
