package com.toy.tripdiary.config;

import org.springframework.security.core.authority.AuthorityUtils;

import com.toy.tripdiary.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SecurityUser extends org.springframework.security.core.userdetails.User {
	
	private Long id;
	private String nickname;
	
	public SecurityUser(User user) {
		super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));		
		this.id = user.getId();
		this.nickname = user.getNickname();
	}

}
