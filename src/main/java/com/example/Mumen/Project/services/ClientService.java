package com.example.Mumen.Project.services;

import java.util.List;

import com.example.Mumen.Project.models.Client;

public interface ClientService {
	
	Client createClient(Client Client);

    Client updateClient(Client Client);

    List < Client > getAllClient();

    Client getClientById(long ClientId);

    void deleteClient(long id);

}
