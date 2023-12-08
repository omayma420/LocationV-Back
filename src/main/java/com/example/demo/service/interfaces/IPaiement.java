package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.persistance.entities.Paiement; 
public interface IPaiement { 

    Paiement savePaiement(Paiement paiement); 
    Paiement updatePaiement(Paiement paiement); 
    boolean deletePaiement(Long id); 
    List<Paiement> getListPaiement(); 
    Paiement getPaiement(Long id);
    int getQuantityOfPaiement(); 
    Paiement getPaiementByIdPaiement(Long id); 
}

