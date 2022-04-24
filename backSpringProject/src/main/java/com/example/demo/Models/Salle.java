package com.example.demo.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name = "t_Salle")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Salle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Salle_id")
	private Long id;
	@Column(nullable = false)
	private String nom ;
	private int capacite;
	private String etat;
	
	@JsonIgnore
	@OneToMany( cascade =CascadeType.ALL, mappedBy = "salle")
	private Set<Session> sessions;
	
	
	public Salle() {}

	public Salle(Long id, String nom, int capacite, String etat, Set<Session> sessions) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.etat = etat;
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
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", nom=" + nom + ", capacite=" + capacite + ", etat=" + etat + ", sessions=" + sessions
				+ "]";
	}

	
	

}
