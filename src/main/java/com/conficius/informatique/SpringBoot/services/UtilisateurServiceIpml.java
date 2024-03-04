package com.conficius.informatique.SpringBoot.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conficius.informatique.SpringBoot.TransfertArgentRequest;
import com.conficius.informatique.SpringBoot.entities.Utilisateur;
import com.conficius.informatique.SpringBoot.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceIpml implements UtilisateurService {

	@Autowired
	public UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurRepository.findAll();
	}
	
	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

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
	
			// Sauvegarder l'utilisateur mis à jour
			return utilisateurRepository.save(existingUser);
		} else {
			return null; // Gérer le cas où l'utilisateur n'est pas trouvé
		}
	}

	@Override
	public void bloquerUtilisateur(Long id) {
		Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
		utilisateurOptional.ifPresent(utilisateur->{
			utilisateur.setEstBloque(true);
			utilisateurRepository.save(utilisateur);
		});
	}

	
	@Override
    public ResponseEntity<String> deposerArgent(Utilisateur utilisateur) {
    Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(utilisateur.getId());

    if (utilisateurOptional.isPresent()) {
        Utilisateur existingUtilisateur = utilisateurOptional.get();

        if (existingUtilisateur.getEstBloque()) {
            return new ResponseEntity<>("Opération non autorisée. Votre compte est bloqué.", HttpStatus.FORBIDDEN);
        }


		existingUtilisateur.setSolde(existingUtilisateur.getSolde().add( utilisateur.getMontantDepot()));
        utilisateurRepository.save(existingUtilisateur);

        return new ResponseEntity<>("Dépôt d'argent réussi.", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Utilisateur non trouvé.", HttpStatus.NOT_FOUND);
    }
}

	@Override
	public Utilisateur getUtilisateurByNumeroTelephone(Long numTelephone) {
		return utilisateurRepository.findByNumTelephone(numTelephone);
	}


	@Override
    public BigDecimal getSoldeUtilisateur(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.map(Utilisateur::getSolde).orElse(null);
    }
	

	
    @Override
    public ResponseEntity<String> transfererArgent(TransfertArgentRequest transfertArgentRequest) {
        Optional<Utilisateur> utilisateurSourceOptional = utilisateurRepository.findById(transfertArgentRequest.getIdUtilisateurSource());
        Optional<Utilisateur> utilisateurDestinataireOptional = utilisateurRepository.findById(transfertArgentRequest.getIdUtilisateurDestinataire());

        if (utilisateurSourceOptional.isPresent() && utilisateurDestinataireOptional.isPresent()) {
            Utilisateur utilisateurSource = utilisateurSourceOptional.get();
            Utilisateur utilisateurDestinataire = utilisateurDestinataireOptional.get();
            BigDecimal montant = transfertArgentRequest.getMontant();

            if (utilisateurSource.getSolde().compareTo(montant) >= 0) {
                // Effectuer le transfert
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
