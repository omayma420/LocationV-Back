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
public class Agence implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nom;
	private String couladresse;
	private String tel; 
	private Date date_creation;
	private Long description;
	public Agence(Long id, String nom, String couladresse, String tel, Date date_creation, Long description) {
		super();
		this.id = id;
		this.nom = nom;
		this.couladresse = couladresse;
		this.tel = tel;
		this.date_creation = date_creation;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCouladresse() {
		return couladresse;
	}
	public void setCouladresse(String couladresse) {
		this.couladresse = couladresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Long getDescription() {
		return description;
	}
	public void setDescription(Long description) {
		this.description = description;
	}
	
	
}