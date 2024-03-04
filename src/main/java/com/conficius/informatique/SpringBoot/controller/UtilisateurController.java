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


@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping(path = "/getAllUtilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurService.getAllUtilisateurs();
	}
	
	  @PostMapping("/ajouter")
	    public ResponseEntity<String> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
	        utilisateurService.createUtilisateur(utilisateur);
	        return new ResponseEntity<>("Utilisateur ajouté avec succès", HttpStatus.CREATED);
	    }
	  
	  @PostMapping("/modifier")
	 
	  public ResponseEntity<String> updateUtilisateur(@RequestBody Utilisateur utilisateur){
		utilisateurService.updateUtilisateur(utilisateur);

		return new ResponseEntity<>("Utilisateur modifié avec succès",HttpStatus.OK);
		
	  }

	   @PutMapping("/bloquer/{idUtilisateur}")
    	public ResponseEntity<String> bloquerUtilisateur(@PathVariable Long idUtilisateur) {
        // Logique pour bloquer l'utilisateur dans le service
        utilisateurService.bloquerUtilisateur(idUtilisateur);
        return new ResponseEntity<>("Utilisateur bloqué avec succès", HttpStatus.OK);
    }

	@PostMapping("/deposerArgent")
	public ResponseEntity<String> deposerArgent(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.deposerArgent(utilisateur);
	}
	  
	@GetMapping("/getByNumeroTelephone/{numTelephone}")
    public ResponseEntity<Utilisateur> getUtilisateurByNumTelephone(@PathVariable Long numTelephone) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurByNumeroTelephone(numTelephone);

        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@GetMapping("/solde/{idUtilisateur}")
    public ResponseEntity<BigDecimal> getSoldeUtilisateur(@PathVariable Long idUtilisateur) {
        BigDecimal solde = utilisateurService.getSoldeUtilisateur(idUtilisateur);

        if (solde != null) {
            return new ResponseEntity<>(solde, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@PostMapping("/transfererArgent")
    public ResponseEntity<String> transfererArgent(@RequestBody TransfertArgentRequest transfertArgentRequest) {
        return utilisateurService.transfererArgent(transfertArgentRequest);
    }
	  
}
