package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Paiement; 
import com.example.demo.service.interfaces.IPaiement; 
@RestController
@RequestMapping("/api/paiement")
public class PaiementController {

    @Autowired
    IPaiement paiementService; 

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Paiement save(@RequestBody Paiement paiement) { 
        System.out.println("*******save ***********");
        Paiement p = paiementService.savePaiement(paiement); 
        return p;
    }

    @GetMapping("/{id}")
    Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiement(id); 
    }

    @GetMapping("/quantity")
    int getQuantityPaiement() { 
        return paiementService.getQuantityOfPaiement(); 
    }

   
    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        paiementService.deletePaiement(id); 
        return true;
    }
}
