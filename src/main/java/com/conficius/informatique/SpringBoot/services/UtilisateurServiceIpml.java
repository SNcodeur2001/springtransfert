package com.conficius.informatique.SpringBoot.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.conficius.informatique.SpringBoot.TransfertArgentRequest;
import com.conficius.informatique.SpringBoot.entities.Utilisateur;
import com.conficius.informatique.SpringBoot.repositories.UtilisateurRepository;

// Annotation pour indiquer que cette classe est un service Spring
@Service
public class UtilisateurServiceIpml implements UtilisateurService {

    // Injection de dépendance pour le repository des utilisateurs
    @Autowired
    public UtilisateurRepository utilisateurRepository;

    // Méthode pour obtenir la liste de tous les utilisateurs
    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Méthode pour créer un nouvel utilisateur
    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Méthode pour mettre à jour un utilisateur existant
    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        Optional<Utilisateur> utOptional = utilisateurRepository.findById(utilisateur.getId());
        if (utOptional.isPresent()) {
            Utilisateur existingUser = utOptional.get();
            existingUser.setNom(utilisateur.getNom());
            existingUser.setPrenom(utilisateur.getPrenom());
            existingUser.setEmail(utilisateur.getEmail());
            existingUser.setRole(utilisateur.getRole());
            existingUser.setSolde(utilisateur.getSolde());
            return utilisateurRepository.save(existingUser);
        } else {
            return null;
        }
    }

    // Méthode pour bloquer un utilisateur par son ID
    @Override
    public void bloquerUtilisateur(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        utilisateurOptional.ifPresent(utilisateur -> {
            utilisateur.setEstBloque(true);
            utilisateurRepository.save(utilisateur);
        });
    }

    // Méthode pour déposer de l'argent sur le compte d'un utilisateur
    @Override
    public ResponseEntity<String> deposerArgent(Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(utilisateur.getId());
        if (utilisateurOptional.isPresent()) {
            Utilisateur existingUtilisateur = utilisateurOptional.get();
            if (existingUtilisateur.getEstBloque()) {
                return new ResponseEntity<>("Opération non autorisée. Votre compte est bloqué.", HttpStatus.FORBIDDEN);
            }
            existingUtilisateur.setSolde(existingUtilisateur.getSolde().add(utilisateur.getMontantDepot()));
            utilisateurRepository.save(existingUtilisateur);
            return new ResponseEntity<>("Dépôt d'argent réussi.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Utilisateur non trouvé.", HttpStatus.NOT_FOUND);
        }
    }

    // Méthode pour obtenir un utilisateur par son numéro de téléphone
    @Override
    public Utilisateur getUtilisateurByNumeroTelephone(Long numTelephone) {
        return utilisateurRepository.findByNumTelephone(numTelephone);
    }

    // Méthode pour obtenir le solde d'un utilisateur par son ID
    @Override
    public BigDecimal getSoldeUtilisateur(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.map(Utilisateur::getSolde).orElse(null);
    }

    // Méthode pour transférer de l'argent entre deux utilisateurs
    @Override
    public ResponseEntity<String> transfererArgent(TransfertArgentRequest transfertArgentRequest) {
        // Recherche des utilisateurs par numéro de téléphone
        Utilisateur utilisateurSource = utilisateurRepository.findByNumTelephone(transfertArgentRequest.getNumeroTelephoneSource());
        Utilisateur utilisateurDestinataire = utilisateurRepository.findByNumTelephone(transfertArgentRequest.getNumeroTelephoneDestinataire());
        if (utilisateurSource != null && utilisateurDestinataire != null) {
            BigDecimal montant = transfertArgentRequest.getMontant();
            if (utilisateurSource.getEstBloque()) {
                return new ResponseEntity<>("Opération non autorisée. Votre compte est bloqué.", HttpStatus.FORBIDDEN);
            }
            if (utilisateurSource.getSolde().compareTo(montant) >= 0) {
                utilisateurSource.setSolde(utilisateurSource.getSolde().subtract(montant));
                utilisateurDestinataire.setSolde(utilisateurDestinataire.getSolde().add(montant));
                utilisateurRepository.save(utilisateurSource);
                utilisateurRepository.save(utilisateurDestinataire);
                return new ResponseEntity<>("Transfert d'argent réussi.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Solde insuffisant.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Utilisateur source ou destinataire non trouvé.", HttpStatus.NOT_FOUND);
        }
    }
}
