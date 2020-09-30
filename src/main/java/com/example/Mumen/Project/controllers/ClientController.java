package com.example.Mumen.Project.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mumen.Project.models.Client;
import com.example.Mumen.Project.services.ClientService;

@RestController
public class ClientController {
	
	@Autowired
    private ClientService ClientService;

    @GetMapping("/clients")
    public ResponseEntity < List < Client >> getAllClient() {
        return ResponseEntity.ok().body(ClientService.getAllClient());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity < Client > getClientById(@PathVariable long id) {
        return ResponseEntity.ok().body(ClientService.getClientById(id));
    }

    @PostMapping("/clients")
    public ResponseEntity < Client > createClient(@RequestBody Client Client) {
        return ResponseEntity.ok().body(this.ClientService.createClient(Client));
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity < Client > updateClient(@PathVariable long id, @RequestBody Client Client) {
        Client.setId(id);
        return ResponseEntity.ok().body(this.ClientService.updateClient(Client));
    }

    @DeleteMapping("/clients/{id}")
    public HttpStatus deleteClient(@PathVariable long id) {
        this.ClientService.deleteClient(id);
        return HttpStatus.OK;
    }

}
