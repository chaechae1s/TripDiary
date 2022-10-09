package com.toy.tripdiary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() throws Exception {
		return "home";
	}
	
	@GetMapping("/access_denied")
	public String access_denied() throws Exception {
		return "denied";
	}

}
