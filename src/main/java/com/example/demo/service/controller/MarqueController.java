package com.example.demo.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Marque;
import com.example.demo.service.interfaces.IMarque;

import java.util.List;

@RestController
@RequestMapping("/api/marque")
public class MarqueController {

    @Autowired
    private IMarque marqueService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    Marque save(@RequestBody Marque marque) {
        System.out.println("******* Save ***********");
        Marque savedMarque = marqueService.saveMarque(marque);
        System.out.println("******* " + savedMarque.getNomMar());
        return savedMarque;
    }

    @GetMapping("/{id}")
    Marque getMarqueById(@PathVariable Long id) {
        return marqueService.getMarque(id);
    }

    @GetMapping("/MarqueBynom/{nomag}")
    Marque getMarquebyName(@PathVariable String nomag) {
        return marqueService.findMarquebynomMar(nomag);
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        marqueService.deleteMarque(id);
        return true;
    }

    @GetMapping("/all")
    List<Marque> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMarque(@PathVariable Long id, @RequestBody Marque updatedMarque) {
        System.out.println("****** Mise à jour de la marque **********");

        Optional<Marque> existingMarqueOptional = marqueService.getMarqueById(id);

        if (existingMarqueOptional.isPresent()) {
            Marque existingMarque = existingMarqueOptional.get();

            existingMarque.setId(updatedMarque.getId());
            existingMarque.setNomMar(updatedMarque.getNomMar());

            Marque updatedMarqueResult = marqueService.updateMarque(existingMarque);

            return ResponseEntity.ok(updatedMarqueResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
