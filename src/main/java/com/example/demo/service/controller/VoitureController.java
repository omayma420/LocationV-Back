package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Voiture;
import com.example.demo.service.interfaces.IVoiture;

@RestController
@RequestMapping("/api/voiture")
public class VoitureController {
	@Autowired
	IVoiture voitureservice;
	private IVoiture service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Voiture save(@RequestBody Voiture voiture) {	
		  System.out.println("*******save ***********");
		  Voiture v=voitureservice.saveVoiture(voiture);
		  System.out.println("*******"+v.getMatricule());
        return v ;
    }
	
	@GetMapping("/{id}")
	Voiture getVoitureById(Long id) {
        return voitureservice.getVoiture(id);
    }
	
	@GetMapping("/voitureBycoulour/{couleur}")
	Voiture getVoitureByCouleur(String couleur) {
        return voitureservice.findVoitureByCouleur(couleur);
    }
	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
		service.deleteVoiture(id);
        return true;
    }
}