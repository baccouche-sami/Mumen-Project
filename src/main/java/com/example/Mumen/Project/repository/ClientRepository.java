package com.example.Mumen.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mumen.Project.models.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
