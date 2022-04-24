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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Activity;
import com.example.demo.Services.ActivityService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ActivityController {
	
	@Autowired  
	ActivityService actService;
	
	
	public ActivityController() {
		
	}

	@GetMapping("/activities")
	List<Activity> allActivities() {
	  return actService.getAllActivities();
	}
	  
	@DeleteMapping("/activities/{id}")
	void deleteActivity(@PathVariable Long id) {
		actService.deleteActivityById(id); 
}
	
	@PostMapping("/activities/add-activity")
	Activity newActivity(@RequestBody Activity act) {
	  return actService.saveActivity(act);
	}
	
	   @PutMapping("/activities/{id}")
	    public Activity updateActivity(@PathVariable(value = "id") Long actId, @RequestBody Activity actDetails)  {
	       Activity act = actService.getActivity(actId); 
	       if(actDetails.getNom()!=null)
	       act.setNom(actDetails.getNom());
	       if(actDetails.getDescription()!=null)
	       act.setDescription(actDetails.getDescription());
	       if(actDetails.getNbHeure()!=0.0)
	       act.setNbHeure(actDetails.getNbHeure());
	       if(actDetails.getPrix()!=0.0)
	       act.setPrix(actDetails.getPrix());

	        final Activity updatedAct = actService.saveActivity(act);
	        return actService.updateActivity(updatedAct);
	    }
	 
	   @GetMapping("/find-activity/{activity_id}")
	   @ResponseBody
		Activity findUser(@PathVariable("activity_id") Long activityId) {
		  return actService.getActivity(activityId);
		}

}
