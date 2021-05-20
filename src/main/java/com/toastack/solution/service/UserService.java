package com.toastack.solution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toastack.solution.model.User;
import com.toastack.solution.repositories.UserRepository;
import com.toastack.solution.security.Authority;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		String encodedPassowrd = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPassowrd);
		
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		
		user.getAuthorities().add(authority);
		return userRepo.save(user);
	}
	
}
