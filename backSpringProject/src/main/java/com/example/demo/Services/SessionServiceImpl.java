package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Activity;
import com.example.demo.Models.Salle;
import com.example.demo.Models.Session;
import com.example.demo.Repositories.ActivityRepository;
import com.example.demo.Repositories.SalleRepository;
import com.example.demo.Repositories.SessionRepository;
@Service
public class SessionServiceImpl implements SessionService{
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	ActivityRepository activityRepository;
	@Autowired
	SalleRepository salleRepository;
	public SessionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session saveSession(Session p) {
		// TODO Auto-generated method stub
		return sessionRepository.save(p);
	}

	@Override
	public void deleteSession(Session p) {
		sessionRepository.delete(p);		
	}

	@Override
	public void deleteSessionById(Long id) {
		sessionRepository.deleteById(id);		
	}

	@Override
	public Session getSession(Long id) {
		return sessionRepository.findById(id).get();

	}

	@Override
	public List<Activity> getAllActivities() {
		return  (List<Activity>) activityRepository.findAll();
	}

	@Override
	public List<Salle> getAllSalles() {
		return  (List<Salle>) salleRepository.findAll();
	}

	@Override
	public List<Session> getAllSessions() {
		// TODO Auto-generated method stub
		return (List<Session>) sessionRepository.findAll();
	}
	@Override
	public Session updateSession(Session s) {
		return sessionRepository.save(s);
	}


}
