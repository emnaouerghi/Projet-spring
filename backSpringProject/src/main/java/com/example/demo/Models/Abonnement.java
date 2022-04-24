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
@Table(name = "t_Abonnement")
public class Abonnement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Abonnement_id")
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER/* fetch =FetchType.LAZY*/)
	private Activity activity;
	
	@ManyToOne(fetch = FetchType.EAGER/* fetch =FetchType.LAZY*/)
	private User user;
	

	private Date dateD,dateF;
	
   public Abonnement () {}
   
	public Abonnement(Long id,User user, Activity activity, Date dateD, Date dateF) {
	super();
	this.id = id;
	this.user = user;
	this.activity = activity;
	this.dateD = dateD;
	this.dateF = dateF;
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

	public void setActivities(Activity activity) {
		this.activity = activity;
	}

	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Abonnement [id=" + id + ", user=" + user + ", activity=" + activity + ", dateD=" + dateD + ", dateF="
				+ dateF + "]";
	}


	

}