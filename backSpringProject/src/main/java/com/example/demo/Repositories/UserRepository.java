package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	//User findByUsername(String username);

	

}
//couche acces au donnees 