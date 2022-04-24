package com.example.demo.Services;

import java.util.List;

import com.example.demo.Models.Activity;
import com.example.demo.Models.Salle;
import com.example.demo.Models.Session;

public interface SessionService {
	  Session saveSession(Session p);
		void deleteSession(Session p);
		void deleteSessionById(Long id);
		Session getSession(Long id);
		List<Activity> getAllActivities();
		List<Salle> getAllSalles();
		List<Session> getAllSessions();
		Session updateSession(Session s);

}
