package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Facture;
import com.example.demo.service.interfaces.IFacture;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
	@Autowired
	IFacture FactureService;
	private IFacture service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Facture save(@RequestBody Facture facture) {	
		  System.out.println("*******save ***********");
		  Facture f=FactureService.saveFacture(facture);
		  System.out.println("*******"+f.getNumero());
        return f  ;
    }
	
	@GetMapping("/{id}")
	Facture getFactureById(@PathVariable Long id) {
        return FactureService.getFacture(id);
    }
	
	
	
	@GetMapping("/FactureBynumero/{numero}")
	Facture getFactureBynumero(@PathVariable Long numero) {
        return FactureService.findFactureBynumero(numero);
    }

	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
		service.deleteFacture(id);
        return true;
    }
}