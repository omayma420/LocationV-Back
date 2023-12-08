package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.ReservationRepository; 
import com.example.demo.persistance.entities.Reservation; 
import com.example.demo.service.interfaces.IReservation;

@Service
public class ReservationService implements IReservation { 

    @Autowired
    ReservationRepository reservationRepository; 

    @Override
    public Reservation saveReservation(Reservation reservation) { 
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) { 
        return reservationRepository.saveAndFlush(reservation);
    }

    @Override
    public boolean deleteReservation(Long id) { 
        reservationRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Reservation> getListReservation() { 
        return reservationRepository.findAll(); 
    }

    @Override
    public Reservation getReservation(Long id) { 
        return reservationRepository.findById(id).get(); 
    }

    @Override
    public int getQuantityOfReservation() { 
        return reservationRepository.getQuantityOfReservation(); 
    }

    @Override
    public Reservation getReservationByIdReservation(Long id) { 
        return null;
    }
}
