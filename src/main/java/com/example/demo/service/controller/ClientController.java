package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Client;
import com.example.demo.service.interfaces.IClient;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	 @Autowired
	    IClient clientService; // Changed from IPatient to IClient

	    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	    Client save(@RequestBody Client client) { // Changed from Patient to Client
	    System.out.println("*******save ***********");
	    Client c = clientService.saveClient(client); // Changed from Patient to Client
	    System.out.println("*******" + c.getEmail());
	    return c;
	    }

	    @GetMapping("/{id}")
	    Client getClientById(@PathVariable Long id) {
	        return clientService.getClient(id);
	    }

	    @GetMapping("/quantity")
	    int getQuantityClient() { // Changed from Patient to Client
	        return clientService.getQuantityOfClient(); // Changed from getQuantityOfPatient to getQuantityOfClient
	    }

	    @GetMapping("/clientByName/{name}") // Changed from patientByName to clientByName
	    Client getClientByName(@PathVariable String name) { // Changed from Patient to Client
	        return clientService.findClientByName(name); // Changed from findPatientByName to findClientByName
	    }

	    @DeleteMapping("/delete/{id}")
	    boolean delete(@PathVariable Long id) {
	        clientService.deleteClient(id); // Changed from deletePatient to deleteClient
	        return true;
	    }
	
	
}
