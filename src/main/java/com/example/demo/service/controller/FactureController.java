package com.example.demo.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Facture;
import com.example.demo.service.interfaces.IFacture;

@RestController
@RequestMapping("/api/facture")
public class FactureController {

    @Autowired
    private IFacture factureService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Facture save(@RequestBody Facture facture) {
        System.out.println("******* Save ***********");
        Facture f = factureService.saveFacture(facture);
        System.out.println("*******" + f.getNumero());
        return f;
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return factureService.getFacture(id);
    }

    @GetMapping("/FactureBynumero/{numero}")
    public Facture getFactureByNumero(@PathVariable Long numero) {
        return factureService.findFactureByNumero(numero);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return true;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFacture(@PathVariable Long id, @RequestBody Facture updatedFacture) {
        System.out.println("****** Update Facture **********");

        Optional<Facture> existingFactureOptional = factureService.getFactureById(id);

        if (existingFactureOptional.isPresent()) {
            Facture existingFacture = existingFactureOptional.get();

            existingFacture.setId(updatedFacture.getId());
            existingFacture.setNumero(updatedFacture.getNumero());
            existingFacture.setMontant(updatedFacture.getMontant());

            Facture updatedFactureResult = factureService.updateFacture(existingFacture);

            return ResponseEntity.ok(updatedFactureResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
