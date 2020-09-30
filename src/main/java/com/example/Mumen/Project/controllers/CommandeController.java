package com.example.Mumen.Project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mumen.Project.exceptions.ResourceNotFoundException;
import com.example.Mumen.Project.models.Commande;
import com.example.Mumen.Project.repository.ClientRepository;
import com.example.Mumen.Project.repository.CommandeRepository;

@RestController
public class CommandeController {
	
	@Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients/{clientId}/commandes")
    public List < Commande > getCommandesByClient(@PathVariable(value = "postId") Long clientId) {
        return commandeRepository.findByClientId(clientId);
    }

    @PostMapping("/clients/{clientId}/commandes")
    public Commande createCommande(@PathVariable(value = "clientId") Long clientId,
        @Valid @RequestBody Commande commande) throws ResourceNotFoundException {
        return clientRepository.findById(clientId).map(client -> {
            commande.setClient(client);
            return commandeRepository.save(commande);
        }).orElseThrow(() -> new ResourceNotFoundException("client not found"));
    }

    @PutMapping("/clients/{clientId}/commandes/{commandeId}")
    public Commande updateCommande(@PathVariable(value = "clientId") Long clientId,
        @PathVariable(value = "commandeId") Long commandeId, @Valid @RequestBody Commande commandeRequest)
    throws ResourceNotFoundException {
        if (!clientRepository.existsById(clientId)) {
            throw new ResourceNotFoundException("clientId not found");
        }

        return commandeRepository.findById(commandeId).map(commande -> {
            commande.setTrappe(commandeRequest.getTrappe());
            commande.setTypeProtection(commandeRequest.getTypeProtection());
            commande.setPrixProtection(commandeRequest.getPrixProtection());
            commande.setMarque(commandeRequest.getMarque());
            commande.setModele(commandeRequest.getModele());
            commande.setImmatriculation(commandeRequest.getImmatriculation());
            commande.setDatePreimma(commandeRequest.getDatePreimma());
            commande.setToit(commandeRequest.getToit());
            commande.setEtiquette(commande.getEtiquette());
            commande.setPhotoCarteGrise(commandeRequest.getPhotoCarteGrise());
            commande.setPhotoVoiture(commandeRequest.getPhotoVoiture());
            return commandeRepository.save(commande);
        }).orElseThrow(() -> new ResourceNotFoundException("commande id not found"));
    }

    @DeleteMapping("/clients/{clientId}/commandes/{commandeId}")
    public ResponseEntity < ? > deleteCommande(@PathVariable(value = "clientId") Long clientId,
        @PathVariable(value = "commandeId") Long commandeId) throws ResourceNotFoundException {
        return commandeRepository.findByIdAndClientId(commandeId, clientId).map(commande -> {
            commandeRepository.delete(commande);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
            "Commande not found with id " + commandeId + " and clientId " + clientId));
    }

}
