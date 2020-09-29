package com.example.Mumen.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mumen.Project.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
