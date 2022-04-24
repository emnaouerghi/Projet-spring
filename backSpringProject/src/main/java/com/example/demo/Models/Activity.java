package com.example.demo.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "t_Activity")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Activity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Activity_id")
	private Long id;
	
	//@Column(nullable = false)
	private String nom;
	private String description;
	private float nbHeure;
	private float prix ;
	

	@JsonIgnore
	@OneToMany( cascade =CascadeType.ALL, mappedBy = "activity")
	@JsonManagedReference
	private Set<Abonnement> abonnements;
	

	@JsonIgnore
	@OneToMany( cascade =CascadeType.ALL, mappedBy = "activity")
	private Set<Session> sessions;

   public Activity() {}

	public Activity(Long id, String nom, String description, float nbHeure, float prix, Set<Abonnement> abonnements,
			Set<Session> sessions) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.nbHeure = nbHeure;
		this.prix = prix;
		this.abonnements = abonnements;
		this.sessions = sessions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getNbHeure() {
		return nbHeure;
	}
	public void setNbHeure(float nbHeure) {
		this.nbHeure = nbHeure;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public Set<Abonnement> getAbonnements() {
		return abonnements;
	}
	public void setAbonnements(Set<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", nom=" + nom + ", description=" + description + ", nbHeure=" + nbHeure
				+ ", prix=" + prix + ", abonnements=" + abonnements + ", sessions=" + sessions + "]";
	}

	
	
	
	

	
}
