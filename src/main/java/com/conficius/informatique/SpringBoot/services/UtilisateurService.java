package com.conficius.informatique.SpringBoot.services;

import java.math.BigDecimal;
import java.util.List;
// import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import com.conficius.informatique.SpringBoot.TransfertArgentRequest;
import com.conficius.informatique.SpringBoot.entities.Utilisateur;

// Interface pour définir les services liés aux utilisateurs
public interface UtilisateurService {

    // Méthode pour obtenir la liste de tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs();

    // Méthode pour créer un nouvel utilisateur
    public Utilisateur createUtilisateur(Utilisateur utilisateur);

    // Méthode pour mettre à jour un utilisateur existant
    public Utilisateur updateUtilisateur(Utilisateur utilisateur);

    // Méthode pour bloquer un utilisateur par son ID
    public void bloquerUtilisateur(Long id);

    // Méthode pour déposer de l'argent sur le compte d'un utilisateur
    public ResponseEntity<String> deposerArgent(Utilisateur utilisateur);

    // Méthode pour obtenir un utilisateur par son numéro de téléphone
    public Utilisateur getUtilisateurByNumeroTelephone(Long numTelephone);

    // Méthode pour obtenir le solde d'un utilisateur par son ID
    public BigDecimal getSoldeUtilisateur(Long id);

    // Méthode pour transférer de l'argent entre deux utilisateurs
    public ResponseEntity<String> transfererArgent(TransfertArgentRequest transfertArgentRequest);
}
