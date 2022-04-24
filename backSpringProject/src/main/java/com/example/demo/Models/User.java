package com.example.demo.Models;

import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "t_User")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
public class User  {
	/**
	 * implements UserDetails
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "User_id")
	private Long id;

   @Column(unique=true )
   private String email;
    
    //@Column(nullable = false)
    private String password;
    
   // @Column(nullable = false)
	private String nom;
    
    private String prenom, adresse ;
    private Date dateInscri;
	private String role;
 
//	private String username;
	// private boolean active;
	@JsonIgnore
	@OneToMany(cascade =CascadeType.ALL, mappedBy = "user")
	private Set<Abonnement> abonnements;
	
	
	public User() {}
	

	public User(Long id, String email, String nom, String password, String prenom, String adresse, Date dateInscri,
			String role, Set<Abonnement> abonnements
			) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.password = password;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateInscri = dateInscri;
		this.role = role;
//	this.username=username;
		this.abonnements=abonnements;}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setTel(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String mdp) {
		this.password = mdp;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateInscri() {
		return dateInscri;
	}
	public void setDateInscri(Date dateInscri) {
		this.dateInscri = dateInscri;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Set<Abonnement>  abonnements) {
		this.abonnements = abonnements;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nom=" + nom + ", mdp=" + password + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", dateInscri=" + dateInscri + ", role=" + role + ", abonnements="
				+ abonnements + "]";
	}


	/*public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}*/


}
