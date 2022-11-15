package com.toy.tripdiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toy.tripdiary.service.SiteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sites")
public class SiteController {
	
	@Autowired
	private final SiteService siteService;
	
	@GetMapping()
	public String findAllSite() throws Exception {
		return "site/list";
	}
	
	@GetMapping("/post")
	public String saveSite() throws Exception {
		return "site/post";
	}

}
