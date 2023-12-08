package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Facture implements Serializable{
	public Facture(Long id, Long numero, Long montant) {
		super();
		this.id = id;
		this.numero = numero;
		this.montant = montant;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private Long numero;
	private Long montant;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
}
