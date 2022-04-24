package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Abonnement;
import com.example.demo.Repositories.AbonnementRepository;
@Service
public class AbonnementServiceImpl implements AbonnementService{

	public AbonnementServiceImpl() {
	}

	@Autowired
	AbonnementRepository abonRepository;


	@Override
	public Abonnement saveAbonnement(Abonnement u) {
		return abonRepository.save(u);
			}

	@Override
	public Abonnement updateAbonnement(Abonnement u) {
		return abonRepository.save(u);
		}

	@Override
	public void deleteAbonnement(Abonnement u) {
		abonRepository.delete(u);
		
	}

	@Override
	public void deleteAbonnementById(Long id) {
		abonRepository.deleteById(id);
		
	}


	@Override
	public List<Abonnement> getAllAbonnements() {
		return (List<Abonnement>) abonRepository.findAll();
	}

	@Override
	public Abonnement getAbonnement(Long id) {
		return abonRepository.findById(id).get();
	}

}