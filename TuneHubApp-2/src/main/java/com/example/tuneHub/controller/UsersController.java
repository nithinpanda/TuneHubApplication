package com.example.tuneHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tuneHub.entities.Users;
import com.example.tuneHub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		boolean userstatus = userv.emailExists(user.getEmail());
		if (userstatus == false) {
			userv.addUser(user);
			return "registerSuccess";
		} else {
			return "registerFail";
		}
		

	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session ) {
		
		if ( userv.validateUser(email, password) == true) {
			
			session.setAttribute("email", email);
			
			//checking the user is admin or not
			if (userv.getRole(email).equals("admin")) {
				return "adminHome";

			} else {
				return "customerHome";
				   }

		} else {
			return "loginFail";
		}
	}
	
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session) {
		String email =(String) session.getAttribute("email");
		Users user =userv.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus == true) {
			return "displaySongs";
		}
		else {
			return "payment";
		}
	}
	
}
