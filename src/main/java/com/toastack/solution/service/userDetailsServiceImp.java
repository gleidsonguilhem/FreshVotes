package com.toastack.solution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.toastack.solution.model.User;
import com.toastack.solution.repositories.UserRepository;
import com.toastack.solution.security.CustomSecurityUser;

@Service
public class userDetailsServiceImp implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username and Password");
		}
		
		return new CustomSecurityUser(user);
	}
	
}
