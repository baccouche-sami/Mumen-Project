package com.example.Mumen.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Mumen.Project.exceptions.ResourceNotFoundException;
import com.example.Mumen.Project.models.Client;
import com.example.Mumen.Project.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	
	@Autowired
    private ClientRepository clientRepository;

	@Override
	public Client createClient(Client Client) {
		// TODO Auto-generated method stub
		 return clientRepository.save(Client);
	}

	@Override
	public Client updateClient(Client Client) {
		// TODO Auto-generated method stub
		Optional < Client > ClientDb = this.clientRepository.findById(Client.getId());

        if (ClientDb.isPresent()) {
            Client ClientUpdate = ClientDb.get();
            ClientUpdate.setId(Client.getId());
            ClientUpdate.setNom(Client.getNom());
            ClientUpdate.setPrenom(Client.getPrenom());
            ClientUpdate.setNomEntreprise(Client.getNomEntreprise());
            ClientUpdate.setPays(Client.getPays());
            ClientUpdate.setAdresse(Client.getAdresse());
            ClientUpdate.setCodePostale(Client.getCodePostale());
            ClientUpdate.setVille(Client.getVille());
            ClientUpdate.setMobile(Client.getMobile());
            ClientUpdate.setEmail(Client.getEmail());
            ClientUpdate.setPassword(Client.getPassword());
            clientRepository.save(ClientUpdate);
            return ClientUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Client.getId());
        }
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return this.clientRepository.findAll();
	}

	@Override
	public Client getClientById(long ClientId) {
		// TODO Auto-generated method stub
		Optional < Client > clientDb = this.clientRepository.findById(ClientId);

        if (clientDb.isPresent()) {
            return clientDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + ClientId);
        }
	}

	@Override
	public void deleteClient(long id) {
		// TODO Auto-generated method stub
		Optional < Client > clientDb = this.clientRepository.findById(id);

        if (clientDb.isPresent()) {
        	this.clientRepository.delete(clientDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
	}

}
