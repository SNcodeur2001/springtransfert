package com.conficius.informatique.SpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.conficius.informatique.SpringBoot.TransfertArgentRequest;
import com.conficius.informatique.SpringBoot.entities.Utilisateur;
import com.conficius.informatique.SpringBoot.services.UtilisateurService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Annotation pour indiquer que cette classe est un contrôleur REST
@RestController
// Annotation pour définir le chemin de base pour toutes les requêtes de ce contrôleur
@RequestMapping("/utilisateur")
public class UtilisateurController {

    // Injection de dépendance pour le service utilisateur
    @Autowired
    private UtilisateurService utilisateurService;

    // Méthode pour obtenir la liste de tous les utilisateurs
    @GetMapping(path = "/getAllUtilisateurs")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    // Méthode pour ajouter un nouvel utilisateur
    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.createUtilisateur(utilisateur);
        return new ResponseEntity<>("Utilisateur ajouté avec succès", HttpStatus.CREATED);
    }

    // Méthode pour modifier un utilisateur existant
    @PostMapping("/modifier")
    public ResponseEntity<String> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(utilisateur);
        return new ResponseEntity<>("Utilisateur modifié avec succès", HttpStatus.OK);
    }

    // Méthode pour bloquer un utilisateur par son ID
    @PutMapping("/bloquer/{idUtilisateur}")
    public ResponseEntity<String> bloquerUtilisateur(@PathVariable Long idUtilisateur) {
        // Logique pour bloquer l'utilisateur dans le service
        utilisateurService.bloquerUtilisateur(idUtilisateur);
        return new ResponseEntity<>("Utilisateur bloqué avec succès", HttpStatus.OK);
    }

    // Méthode pour déposer de l'argent sur le compte d'un utilisateur
    @PostMapping("/deposerArgent")
    public ResponseEntity<String> deposerArgent(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.deposerArgent(utilisateur);
    }

    // Méthode pour obtenir un utilisateur par son numéro de téléphone
    @GetMapping("/getByNumeroTelephone/{numTelephone}")
    public ResponseEntity<Utilisateur> getUtilisateurByNumTelephone(@PathVariable Long numTelephone) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurByNumeroTelephone(numTelephone);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Méthode pour obtenir le solde d'un utilisateur par son ID
    @GetMapping("/solde/{idUtilisateur}")
    public ResponseEntity<BigDecimal> getSoldeUtilisateur(@PathVariable Long idUtilisateur) {
        BigDecimal solde = utilisateurService.getSoldeUtilisateur(idUtilisateur);
        if (solde != null) {
            return new ResponseEntity<>(solde, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Méthode pour transférer de l'argent entre deux utilisateurs
    @PostMapping("/transfererArgent")
    public ResponseEntity<String> transfererArgent(@RequestBody TransfertArgentRequest transfertArgentRequest) {
        return utilisateurService.transfererArgent(transfertArgentRequest);
    }
}
