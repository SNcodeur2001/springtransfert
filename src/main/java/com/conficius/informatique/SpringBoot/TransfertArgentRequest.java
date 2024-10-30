package com.conficius.informatique.SpringBoot;

import java.math.BigDecimal;

public class TransfertArgentRequest {
    private Long numeroTelephoneSource;
    private Long numeroTelephoneDestinataire;
    private BigDecimal montant;

    public TransfertArgentRequest() {
    }

    public TransfertArgentRequest(Long numeroTelephoneSource, Long numeroTelephoneDestinataire, BigDecimal montant) {
        this.numeroTelephoneSource = numeroTelephoneSource;
        this.numeroTelephoneDestinataire = numeroTelephoneDestinataire;
        this.montant = montant;
    }

    public Long getNumeroTelephoneSource() {
        return numeroTelephoneSource;
    }

    public Long getNumeroTelephoneDestinataire() {
        return numeroTelephoneDestinataire;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setNumeroTelephoneSource(Long numeroTelephoneSource) {
        this.numeroTelephoneSource = numeroTelephoneSource;
    }

    public void setNumeroTelephoneDestinataire(Long numeroTelephoneDestinataire) {
        this.numeroTelephoneDestinataire = numeroTelephoneDestinataire;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
