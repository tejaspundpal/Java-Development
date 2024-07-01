package com.springboot.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springboot.projects.dao.UserRepository;
import com.springboot.projects.entities.Contact;
import com.springboot.projects.entities.User;
import com.springboot.projects.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/")
	public String home(Model model){
		
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model){
		
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model){
		
		model.addAttribute("title", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	//Handler for registering user
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,@RequestParam(value="agreement",defaultValue = "false") boolean agreement,Model model,HttpSession session){
		
		try {
			if(!agreement) {
				System.out.println("You have not agreed terms and conditions!");
				throw new Exception("You have not agreed terms and conditions!");
			}
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
						
			System.out.println("Agreement : "+agreement);
			System.out.println("User : "+ user);
			
			this.userRepo.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Succesfully Registerd", "alert-success"));
			return "signup";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something Went Wrong !"+e.getMessage(), "alert-danger"));
			return "signup";
		}
		
	}
}
