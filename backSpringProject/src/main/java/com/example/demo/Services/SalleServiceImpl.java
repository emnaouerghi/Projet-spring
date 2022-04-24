package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Salle;
import com.example.demo.Repositories.SalleRepository;
@Service
public class SalleServiceImpl implements SalleService {
 @Autowired
 SalleRepository salleRepo;
	public SalleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Salle saveSalle(Salle s) {
		return salleRepo.save(s);
	}

	@Override
	public Salle updateSalle(Salle s) {
		return salleRepo.save(s);
	}

	@Override
	public void deleteSalle(Salle s) {
		salleRepo.delete(s);		
	}

	@Override
	public void deleteSalleById(Long id) {
		salleRepo.deleteById(id);
	}

	@Override
	public Salle getSalle(Long id) {
		return salleRepo.findById(id).get();

	}

	@Override
	public List<Salle> getAllSalles() {
		return (List<Salle>) salleRepo.findAll();

	}

}
