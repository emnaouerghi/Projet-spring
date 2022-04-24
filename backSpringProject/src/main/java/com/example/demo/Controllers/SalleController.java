package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Activity;
import com.example.demo.Models.Salle;
import com.example.demo.Models.User;
import com.example.demo.Services.SalleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SalleController {

	public SalleController() {
		// TODO Auto-generated constructor stub
	}
@Autowired
SalleService salleService;

@GetMapping("/salles")
List<Salle> allSalles() {
  return salleService.getAllSalles();
}
  
@DeleteMapping("/salles/{id}")
void deleteSalle(@PathVariable Long id) {
	salleService.deleteSalleById(id);
}

@PostMapping("/salles/add-salle")
Salle newSalle(@RequestBody Salle salle) {
  return salleService.saveSalle(salle);
}

@PutMapping("/salles/{id}")
 public Salle updateUser(@PathVariable(value = "id") Long salleId, @RequestBody Salle salleDetails)  {
     Salle salle = salleService.getSalle(salleId); 
     if (salleDetails.getNom()!=null) 
         salle.setNom(salleDetails.getNom());
     
     
     if (salleDetails.getEtat()!=null) 
         salle.setEtat(salleDetails.getEtat());
     
     if(salleDetails.getCapacite()!=0)
     salle.setCapacite(salleDetails.getCapacite());


     final Salle updatedSalle = salleService.saveSalle(salle);
     return salleService.updateSalle(updatedSalle);
 }
}
