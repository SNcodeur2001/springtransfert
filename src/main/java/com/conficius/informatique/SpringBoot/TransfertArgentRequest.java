package com.conficius.informatique.SpringBoot;

import java.math.BigDecimal;

// Classe représentant une requête de transfert d'argent
public class TransfertArgentRequest {

    // Numéro de téléphone de la source du transfert
    private Long numeroTelephoneSource;

    // Numéro de téléphone du destinataire du transfert
    private Long numeroTelephoneDestinataire;

    // Montant du transfert
    private BigDecimal montant;

    // Constructeur par défaut
    public TransfertArgentRequest() {
    }

    // Constructeur avec paramètres pour initialiser les champs
    public TransfertArgentRequest(Long numeroTelephoneSource, Long numeroTelephoneDestinataire, BigDecimal montant) {
        this.numeroTelephoneSource = numeroTelephoneSource;
        this.numeroTelephoneDestinataire = numeroTelephoneDestinataire;
        this.montant = montant;
    }

    // Getter pour le numéro de téléphone source
    public Long getNumeroTelephoneSource() {
        return numeroTelephoneSource;
    }

    // Getter pour le numéro de téléphone destinataire
    public Long getNumeroTelephoneDestinataire() {
        return numeroTelephoneDestinataire;
    }

    // Getter pour le montant du transfert
    public BigDecimal getMontant() {
        return montant;
    }

    // Setter pour le numéro de téléphone source
    public void setNumeroTelephoneSource(Long numeroTelephoneSource) {
        this.numeroTelephoneSource = numeroTelephoneSource;
    }

    // Setter pour le numéro de téléphone destinataire
    public void setNumeroTelephoneDestinataire(Long numeroTelephoneDestinataire) {
        this.numeroTelephoneDestinataire = numeroTelephoneDestinataire;
    }

    // Setter pour le montant du transfert
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
