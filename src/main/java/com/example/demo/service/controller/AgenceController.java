package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Agence;
import com.example.demo.service.interfaces.IAgence;

@RestController
@RequestMapping("/api/agence")
public class AgenceController {
	@Autowired
	IAgence Agenceservice;
	private IAgence service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Agence save(@RequestBody Agence agence) {	
		  System.out.println("*******save ***********");
		  Agence a=Agenceservice.saveAgence(agence);
		  System.out.println("*******"+a.getNom());
        return a  ;
    }
	
	@GetMapping("/{id}")
	Agence getAgenceById(@PathVariable Long id) {
        return Agenceservice.getAgence(id);
    }
	
	@GetMapping("/quantity")
    int getQuantityAgence() {
        return Agenceservice.getQuantityOfAgence();
    }
	
	@GetMapping("/AgenceBynom/{nomag}")
	Agence getAgencebyName(@PathVariable String name) {
        return Agenceservice.findAgenceByName(name);
    }
	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
		service.deleteAgence(id);
        return true;
    }
}