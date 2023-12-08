package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Reservation; 
import com.example.demo.service.interfaces.IReservation; 
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    IReservation reservationService; // Changed from IPaiement to IReservation

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Reservation save(@RequestBody Reservation reservation) { 
        System.out.println("*******save ***********");
        Reservation r = reservationService.saveReservation(reservation); 
        return r;
    }

    @GetMapping("/{id}")
    Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservation(id); 
    }

    @GetMapping("/quantity")
    int getQuantityReservation() { 
        return reservationService.getQuantityOfReservation(); 
    }

    

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        reservationService.deleteReservation(id); 
        return true;
    }
}

