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
import com.example.demo.Models.Session;
import com.example.demo.Services.ActivityService;
import com.example.demo.Services.SalleService;
import com.example.demo.Services.SessionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {
@Autowired
private SessionService sessionService;

@Autowired
private ActivityService activityService;

@Autowired
private SalleService salleService;

	public SessionController() {
	}
	@GetMapping("/sessions")
	List<Session> allSessions() {
	  return sessionService.getAllSessions();
	}
	  
	@DeleteMapping("/sessions/{id}")
	void deleteSession(@PathVariable Long id) {
		sessionService.deleteSessionById(id); 
}
	
	@PostMapping("/add-session/{idActivity}/{idSalle}")
	Session newSession(@RequestBody Session sess,@PathVariable Long idActivity,@PathVariable Long idSalle) {
	 Activity act=activityService.getActivity(idActivity);
	 Salle s=salleService.getSalle(idSalle);
	 sess.setActivity(act);
	 sess.setSalle(s);
	  return sessionService.saveSession(sess);
	}
	
	   @PutMapping("/sessions/{id}")
	    public Session updateSession(@PathVariable(value = "id") Long sessId, @RequestBody Session sessDetails)  {
	        Session s = sessionService.getSession(sessId); 
	       s.setHeure(sessDetails.getHeure());
	       s.setDateDp(sessDetails.getDateDp());
	    
	        final Session updatedSess= sessionService.saveSession(s);
	        return sessionService.updateSession(updatedSess);
	    }
}
