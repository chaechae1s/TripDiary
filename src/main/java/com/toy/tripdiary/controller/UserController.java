package com.toy.tripdiary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.toy.tripdiary.domain.User;
import com.toy.tripdiary.dto.UserDTO;
import com.toy.tripdiary.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/join")
	public String join() throws Exception {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(UserDTO userDTO) {
		userService.join(userDTO);
		
		return "redirect:/";
		
	}

	@GetMapping("/login")
	public String login() throws Exception {
		return "user/login";
	}
	
	@GetMapping("/{id}")
	public String myPage(@PathVariable Long id) throws Exception {
		
		
		return "user/mypage";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) throws Exception {
		User user = userService.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user/edit");
		
		return mv;
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable Long id, User user) throws Exception {
		return null;
	}
}
