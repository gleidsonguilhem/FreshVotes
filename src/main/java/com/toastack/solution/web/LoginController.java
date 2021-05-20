package com.toastack.solution.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.toastack.solution.model.User;
import com.toastack.solution.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String rootView() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(User user) {
		userService.save(user);
		return "redirect:/register";
	}
	
	
}
