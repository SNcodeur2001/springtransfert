package com.conficius.informatique.SpringBoot.services;


import java.math.BigDecimal;
import java.util.List;

// import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.conficius.informatique.SpringBoot.TransfertArgentRequest;
import com.conficius.informatique.SpringBoot.entities.Utilisateur;

public interface UtilisateurService {
	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur createUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
	public void bloquerUtilisateur(Long id);
	public ResponseEntity<String> deposerArgent(Utilisateur utilisateur);
	public Utilisateur getUtilisateurByNumeroTelephone(Long numTelephone);
    public BigDecimal getSoldeUtilisateur(Long id);

	public ResponseEntity<String> transfererArgent(TransfertArgentRequest transfertArgentRequest);

}
