package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Marque;
import com.example.demo.service.interfaces.IMarque;

@RestController
@RequestMapping("/api/marque")
public class MarqueController  {
	@Autowired
	IMarque Marqueservice;
	private IMarque service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Marque save(@RequestBody Marque marque) {	
		  System.out.println("*******save ***********");
		  Marque m=Marqueservice.saveMarque(marque);
		  System.out.println("*******"+m.getNomMar());
        return m  ;
    }
	
	@GetMapping("/{id}")
	Marque getMarqueById(@PathVariable Long id) {
        return Marqueservice.getMarque(id);
    }
	
	@GetMapping("/MarqueBynom/{nomag}")
	Marque getMarquebyName(@PathVariable String name) {
        return Marqueservice.findMarquebynomMar(name);
    }
	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
		service.deleteMarque(id);
        return true;
    }
}