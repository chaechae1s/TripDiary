package com.toy.tripdiary.config;

import org.springframework.security.core.authority.AuthorityUtils;

import com.toy.tripdiary.domain.User;

public class SecurityUser extends org.springframework.security.core.userdetails.User {
	
	private User user;
	
	public SecurityUser(User user) {
		super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		
		this.user = user;
	}

}
