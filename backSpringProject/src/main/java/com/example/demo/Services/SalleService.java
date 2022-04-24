package com.example.demo.Services;

import java.util.List;

import com.example.demo.Models.Salle;

public interface SalleService {
	  Salle saveSalle(Salle s);
		Salle updateSalle(Salle s);
		void deleteSalle(Salle s);
		void deleteSalleById(Long id);
	  Salle getSalle(Long id);
		List<Salle> getAllSalles();
}
