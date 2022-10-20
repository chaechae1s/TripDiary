package com.toy.tripdiary.config;

import org.springframework.security.core.authority.AuthorityUtils;

import com.toy.tripdiary.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SecurityUser extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	
	public SecurityUser(User user) {
		super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));		
		
		this.user = user;
	}

}
