package com.example.Mumen.Project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mumen.Project.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	List<Commande> findByClientId(Long clientId);
	 Optional<Commande> findByIdAndClientId(Long id, Long clientId);
}
