package com.conficius.informatique.SpringBoot.entities;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private Long numTelephone;
	private String mot_de_passe;
	private BigDecimal solde;
	private String role;
	private boolean estBloque;
	

    private BigDecimal montantDepot = BigDecimal.ZERO;



	public Long getNumTelephone() {
		return numTelephone;
	}

	public void setNum_telephone(Long numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public boolean getEstBloque(){
		return estBloque;
	}

	public void setEstBloque(boolean estBloque){
		this.estBloque = estBloque;
	}


	public BigDecimal getMontantDepot(){
		return montantDepot;
	}

	public void setMontantDepot(BigDecimal montantDepot){
		this.montantDepot = montantDepot;
	}

	

}
