package com.example.demo.Services;

import java.util.List;

import com.example.demo.Models.Abonnement;

public interface AbonnementService {
	Abonnement saveAbonnement(Abonnement p);
	Abonnement updateAbonnement(Abonnement p);
	void deleteAbonnement(Abonnement p);
	void deleteAbonnementById(Long id);
	Abonnement getAbonnement(Long id);
	List<Abonnement> getAllAbonnements();
}