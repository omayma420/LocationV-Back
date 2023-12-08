package com.example.demo.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Voiture;
import com.example.demo.service.interfaces.IVoiture;

@RestController
@RequestMapping("/api/voiture")
public class VoitureController {

    @Autowired
    private IVoiture voitureservice;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Voiture save(@RequestBody Voiture voiture) {
        System.out.println("******* Save ***********");
        Voiture v = voitureservice.saveVoiture(voiture);
        System.out.println("*******" + v.getMatricule());
        return v;
    }

    @GetMapping("/{id}")
    public Voiture getVoitureById(@PathVariable Long id) {
        return voitureservice.getVoiture(id);
    }

    @GetMapping("/voitureBycoulour/{couleur}")
    public Voiture getVoitureByCouleur(@PathVariable String couleur) {
        return voitureservice.findVoitureByCouleur(couleur);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        voitureservice.deleteVoiture(id);
        return true;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Voiture> getAllVoitures() {
        return voitureservice.getAllvoitures();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVoiture(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
        System.out.println("****** Update **********");

        Optional<Voiture> existingVoitureOptional = voitureservice.getVoitureById(id);

        if (existingVoitureOptional.isPresent()) {
            Voiture existingVoiture = existingVoitureOptional.get();

            existingVoiture.setId(updatedVoiture.getId());
            existingVoiture.setMatricule(updatedVoiture.getMatricule());
            existingVoiture.setCouleur(updatedVoiture.getCouleur());

            Voiture updatedVoitureResult = voitureservice.updateVoiture(existingVoiture);

            return ResponseEntity.ok(updatedVoitureResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
