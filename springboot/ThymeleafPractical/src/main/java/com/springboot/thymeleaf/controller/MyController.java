package com.springboot.thymeleaf.controller;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about(Model model) {
		System.out.println("inside about handler");
		model.addAttribute("name", "Tejas Pundpal");
		model.addAttribute("currentDate", new Date().toLocaleString());
		
		List<String> names = List.of("Tejas","TP","Tejya","TTP");
		model.addAttribute("names", names);

		model.addAttribute("isActive", false);
		model.addAttribute("gender", "F");
		
		return "about";
		//about.html
	}

	@RequestMapping(value="/fragment",method=RequestMethod.GET)
	public String fragment(Model model) {
		return "fragment";
	}
}
