package com.conficius.informatique.SpringBoot.entities;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Annotation pour indiquer que cette classe est une entité JPA
@Entity
public class Utilisateur {

    // Annotation pour indiquer que ce champ est la clé primaire
    @Id
    // Annotation pour indiquer que la valeur de ce champ est générée automatiquement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Champ pour stocker le nom de l'utilisateur
    private String nom;

    // Champ pour stocker le prénom de l'utilisateur
    private String prenom;

    // Champ pour stocker l'email de l'utilisateur
    private String email;

    // Champ pour stocker le numéro de téléphone de l'utilisateur
    private Long numTelephone;

    // Champ pour stocker le mot de passe de l'utilisateur
    private String mot_de_passe;

    // Champ pour stocker le solde de l'utilisateur
    private BigDecimal solde;

    // Champ pour stocker le rôle de l'utilisateur (par exemple, admin, utilisateur)
    private String role;

    // Champ pour indiquer si l'utilisateur est bloqué
    private boolean estBloque;

    // Champ pour stocker le montant du dépôt, initialisé à zéro
    private BigDecimal montantDepot = BigDecimal.ZERO;

    // Getter pour le numéro de téléphone
    public Long getNumTelephone() {
        return numTelephone;
    }

    // Setter pour le numéro de téléphone
    public void setNum_telephone(Long numTelephone) {
        this.numTelephone = numTelephone;
    }

    // Getter pour le rôle
    public String getRole() {
        return role;
    }

    // Setter pour le rôle
    public void setRole(String role) {
        this.role = role;
    }

    // Getter pour l'ID
    public Long getId() {
        return id;
    }

    // Setter pour l'ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Setter pour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour le prénom
    public String getPrenom() {
        return prenom;
    }

    // Setter pour le prénom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter pour l'email
    public String getEmail() {
        return email;
    }

    // Setter pour l'email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter pour le mot de passe
    public String getMot_de_passe() {
        return mot_de_passe;
    }

    // Setter pour le mot de passe
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    // Getter pour le solde
    public BigDecimal getSolde() {
        return solde;
    }

    // Setter pour le solde
    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    // Getter pour savoir si l'utilisateur est bloqué
    public boolean getEstBloque() {
        return estBloque;
    }

    // Setter pour bloquer ou débloquer l'utilisateur
    public void setEstBloque(boolean estBloque) {
        this.estBloque = estBloque;
    }

    // Getter pour le montant du dépôt
    public BigDecimal getMontantDepot() {
        return montantDepot;
    }

    // Setter pour le montant du dépôt
    public void setMontantDepot(BigDecimal montantDepot) {
        this.montantDepot = montantDepot;
    }
}
