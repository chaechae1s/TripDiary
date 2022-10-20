package com.toy.tripdiary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.toy.tripdiary.domain.User;
import com.toy.tripdiary.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	@GetMapping("/join")
	public String join() throws Exception {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(User user) throws Exception {
		userService.join(user);
		
		return "redirect:/";
		
	}

	@GetMapping("/login")
	public String login() throws Exception {
		return "user/login";
	}
	
	@GetMapping("/{id}")
	public String myPage(@PathVariable("id") Long id) throws Exception {
		
		return "user/mypage";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) throws Exception {
		User user = userService.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user/edit");
			
		return mv;
	}
	
	@PutMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, User user)	throws Exception {
		userService.edit(user);
		
		return "redirect:./"+id;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) throws Exception {
		userService.delete(id);
		SecurityContextHolder.clearContext();
		
		return "redirect:/";
	}
	
	
}
