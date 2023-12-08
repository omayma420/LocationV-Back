package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Agence;
import com.example.demo.service.interfaces.IAgence;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agence")
public class AgenceController {

    @Autowired
    private IAgence agenceService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    Agence save(@RequestBody Agence agence) {
        System.out.println("******* Save ***********");
        Agence savedAgence = agenceService.saveAgence(agence);
        System.out.println("******* " + savedAgence.getNom());
        return savedAgence;
    }

    @GetMapping("/{id}")
    Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgence(id);
    }

    @GetMapping("/quantity")
    int getQuantityAgence() {
        return agenceService.getQuantityOfAgence();
    }

    @GetMapping("/AgenceBynom/{nomag}")
    Agence getAgencebyName(@PathVariable String nomag) {
        return agenceService.findAgenceByName(nomag);
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        agenceService.deleteAgence(id);
        return true;
    }

    @GetMapping
    List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAgence(@PathVariable Long id, @RequestBody Agence updatedAgence) {
        System.out.println("****** Mise à jour de l'agence **********");

        Optional<Agence> existingAgenceOptional = agenceService.getAgenceById(id);

        if (existingAgenceOptional.isPresent()) {
            Agence existingAgence = existingAgenceOptional.get();

            existingAgence.setId(updatedAgence.getId());
            existingAgence.setNom(updatedAgence.getNom());
            existingAgence.setCouladresse(updatedAgence.getCouladresse());
            existingAgence.setTel(updatedAgence.getTel());
            existingAgence.setDate_creation(updatedAgence.getDate_creation());
            existingAgence.setDescription(updatedAgence.getDescription());

            Agence updatedAgenceResult = agenceService.updateAgence(existingAgence);

            return ResponseEntity.ok(updatedAgenceResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
