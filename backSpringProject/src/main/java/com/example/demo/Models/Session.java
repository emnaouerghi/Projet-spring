package com.example.demo.Models;

import java.util.Date;
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
@Entity
@Table(name = "t_Session")
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Session_id")
	private Long id;
	
	private Date dateDp;
	private String heure;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER/* fetch =FetchType.LAZY*/)
	private Activity activity;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER/* fetch =FetchType.LAZY*/)
	private Salle salle;
	
	
    public Session() {}

	public Session(Long id,Activity activity, Salle salle, Date dateDp, String heure) {
		super();
		this.id = id;
		this.activity = activity;
		this.salle = salle;
		this.dateDp = dateDp;
		this.heure = heure;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Date getDateDp() {
		return dateDp;
	}


	public void setDateDp(Date dateDp) {
		this.dateDp = dateDp;
	}


	public String getHeure() {
		return heure;
	}


	public void setHeure(String heure) {
		this.heure = heure;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", dateDp=" + dateDp + ", heure=" + heure + ", activity=" + activity + ", salle="
				+ salle + "]";
	}


	
	

}
