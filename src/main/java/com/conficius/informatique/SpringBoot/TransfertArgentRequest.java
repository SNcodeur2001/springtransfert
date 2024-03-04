package com.conficius.informatique.SpringBoot;

import java.math.BigDecimal;

public class TransfertArgentRequest {
    private Long idUtilisateurSource;
    private Long idUtilisateurDestinataire;
    private BigDecimal montant;

    // Constructeurs

    public TransfertArgentRequest() {
        // Constructeur par défaut
    }

    public TransfertArgentRequest(Long idUtilisateurSource, Long idUtilisateurDestinataire, BigDecimal montant) {
        this.idUtilisateurSource = idUtilisateurSource;
        this.idUtilisateurDestinataire = idUtilisateurDestinataire;
        this.montant = montant;
    }

    // Getters

    public Long getIdUtilisateurSource() {
        return idUtilisateurSource;
    }

    public Long getIdUtilisateurDestinataire() {
        return idUtilisateurDestinataire;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    // Setters

    public void setIdUtilisateurSource(Long idUtilisateurSource) {
        this.idUtilisateurSource = idUtilisateurSource;
    }

    public void setIdUtilisateurDestinataire(Long idUtilisateurDestinataire) {
        this.idUtilisateurDestinataire = idUtilisateurDestinataire;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
