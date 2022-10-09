package com.toy.tripdiary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toy.tripdiary.domain.Role;
import com.toy.tripdiary.domain.User;
import com.toy.tripdiary.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Long join(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		user.setEnabled(true);
		userRepository.save(user);
		
		return user.getId();
		
	}
	
	public User findById(Long id) throws Exception {
		
		User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		
		return user;
	}

}
