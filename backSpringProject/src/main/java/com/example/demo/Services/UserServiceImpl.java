package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	PasswordEncoder passwordEncoder;
	public UserServiceImpl() {
		this.passwordEncoder=new BCryptPasswordEncoder();
}

	@Override
	public User saveUser(User u) {
		String encodedPassword =this.passwordEncoder.encode(u.getPassword());
		u.setPassword(encodedPassword);
		return userRepository.save(u);
			}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
		}

	@Override
	public void deleteUser(User u) {
		userRepository.delete(u);
		
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

/*	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}*/



}
