package com.toastack.solution.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


class userDetailsServiceTest {

	@Test
	void check_password_encoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String rawPassword = "Password123";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
		
		assertNotEquals(rawPassword, encodedPassword);
		
	}

}
