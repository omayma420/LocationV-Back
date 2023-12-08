package com.example.demo.persistance.entities;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Voiture implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String matricule;
	private String couleur;
	private String modele; 
	private Date date_fab;
	private Long prix_location;
	public Voiture(Long id, String matricule, String couleur, String modele, Date date_fab, Long prix_location) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.couleur = couleur;
		this.modele = modele;
		this.date_fab = date_fab;
		this.prix_location = prix_location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public Date getDate_fab() {
		return date_fab;
	}
	public void setDate_fab(Date date_fab) {
		this.date_fab = date_fab;
	}
	public Long getPrix_location() {
		return prix_location;
	}
	public void setPrix_location(Long prix_location) {
		this.prix_location = prix_location;
	}
}
	