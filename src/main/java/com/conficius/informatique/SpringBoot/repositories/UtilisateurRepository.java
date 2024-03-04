package com.conficius.informatique.SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conficius.informatique.SpringBoot.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
    
    Utilisateur findByNumTelephone(Long numTelephone);
}  
