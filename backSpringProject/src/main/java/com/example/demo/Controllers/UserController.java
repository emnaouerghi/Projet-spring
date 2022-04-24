package com.example.demo.Controllers;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired  
	UserService usersService; 

	public UserController( ) {
		//this.userRepo=userRepo;
}
	
	@GetMapping("/users")
	List<User> allUsers() {
	  return (List<User>) usersService.getAllUsers();
	}
	@GetMapping("/users/find-user/{user_id}")
	@ResponseBody
	User findUser(@PathVariable("user_id") Long userId) {
	  return usersService.getUser(userId);
	}
	  
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		usersService.deleteUserById(id); 
}
	
	@PostMapping("/users/add-user")
	@ResponseBody User newUser(@RequestBody User newUser) {
	  return usersService.saveUser(newUser);
	}

	   
	   @PutMapping("/users/{id}")
	    public User updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails)  {
	        User user = usersService.getUser(userId); 
	       if(userDetails.getAdresse()!=null)
	       user.setAdresse(userDetails.getAdresse());
	      if(userDetails.getDateInscri()!=null)
	       user.setDateInscri(userDetails.getDateInscri());
	       if(userDetails.getEmail()!=null)
	       user.setEmail(userDetails.getEmail());
	       if(userDetails.getNom()!=null)
	       user.setNom(userDetails.getNom());
	       if(userDetails.getPrenom()!=null)
	       user.setPrenom(userDetails.getPrenom());
	       if(userDetails.getRole()!=null)
	       user.setRole(userDetails.getRole());
	       
	   
	        final User updatedUser = usersService.saveUser(user);
	        return usersService.updateUser(updatedUser);
	    }
   

	  /* @GetMapping("/token/refresh")
		public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String authorizationHeader = request.getHeader(AUTHORIZATION);
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				try {
					String refresh_token =authorizationHeader.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = verifier.verify(refresh_token);
					String username = decodedJWT.getSubject();
					User user = usersService.findUser(username);
					String access_token =JWT.create()
							.withSubject(user.getUsername())
							.withExpiresAt(new Date(System.currentTimeMillis() + 10*60*1000))
							.withIssuer(request.getRequestURL().toString())
							.withClaim("role", user.getRole())
							.sign(algorithm);
					Map<String,String> tokens = new HashMap<>();
					tokens.put("access_token", access_token);
					tokens.put("refresh_token", refresh_token);
				//	response.setContentType(MediaType.APPLICATION_JSON_VALUE);
					new ObjectMapper().writeValue(response.getOutputStream(), tokens);
				}catch(Exception exception) {
					response.setHeader("error",exception.getMessage());
					response.setStatus(org.springframework.http.HttpStatus.FORBIDDEN.value());
					//response.sendError(org.springframework.http.HttpStatus.FORBIDDEN.value());
					Map<String,String> error = new HashMap<>();
					error.put("error_message", exception.getMessage());
					//response.setContentType(MediaType.APPLICATION_JSON_VALUE);
					new ObjectMapper().writeValue(response.getOutputStream(), error);
				}
			}else {
						throw new RuntimeException("Refresh token is missing ");		}

		}*/
}

