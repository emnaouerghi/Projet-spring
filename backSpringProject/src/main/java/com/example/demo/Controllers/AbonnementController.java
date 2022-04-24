package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Abonnement;
import com.example.demo.Models.Activity;
import com.example.demo.Models.User;
import com.example.demo.Services.AbonnementService;
import com.example.demo.Services.ActivityService;
import com.example.demo.Services.MailService;
import com.example.demo.Services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AbonnementController {

	public AbonnementController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired  
	AbonnementService abonService;
	
	@Autowired  
	UserService userService;
	
	@Autowired  
	ActivityService activityService;
	
	
    @Autowired
    private MailService mailService;
	
	@GetMapping("/abonnements")
	List<Abonnement> allAbonnements() {
	  return abonService.getAllAbonnements();
	}
	  
	@DeleteMapping("/abonnements/{id}")
	void deleteUser(@PathVariable Long id) {
		abonService.deleteAbonnementById(id); 
}
	
	@PostMapping("/add-abonnement/{id}/{idAct}")
	Abonnement newAbonnement(@RequestBody Abonnement abon,@PathVariable Long id,@PathVariable Long idAct) {
	
	User user=userService.getUser(id);
	Activity act=activityService.getActivity(idAct);
		
		
	abon.setUser(user);
	abon.setActivities(act);
		
	  return abonService.saveAbonnement(abon);
	}
	
	   @PutMapping("/abonnements/{id}")
	    public Abonnement updateAbonnement(@PathVariable(value = "id") Long abonId, @RequestBody Abonnement abonDetails)  {
	        Abonnement abon = abonService.getAbonnement(abonId); 
	        if(abonDetails.getDateD()!=null)
	        abon.setDateD(abonDetails.getDateD());
	        
	        if(abonDetails.getDateF()!=null)
	        abon.setDateF(abonDetails.getDateF());
	      
	    //  abon.setActivities(abonDetails.getActivity());
	   //   abon.setUser(abonDetails.getUser());
	       
	        final Abonnement updatedAbon= abonService.saveAbonnement(abon);
	        return abonService.updateAbonnement(updatedAbon);
	    }
	   @ResponseBody
	   @RequestMapping("/abonnements/sendMail/{id}")
	   public String sendMail (@PathVariable Long id) {
		Abonnement abon=abonService.getAbonnement(id);
		User user=abon.getUser();
		String body="Hello \n Congratulations on being part of the team! The whole Club'na welcomes you, and we look forward to a successful journey with you! Welcome aboard!!";
		
		mailService.send(user.getEmail(), "Confirmation Abonnement Club'na ",body);

		return "Mail sent successfuly";
		   
	   }
  

}
