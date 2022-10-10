package com.toy.tripdiary.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.tripdiary.domain.Role;
import com.toy.tripdiary.domain.User;
import com.toy.tripdiary.dto.UserDTO;
import com.toy.tripdiary.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional
	public Long join(UserDTO userDTO) {
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));
		userDTO.setRole(Role.ROLE_USER);
		userDTO.setEnabled(true);
		
		return userRepository.save(userDTO.toEntity()).getId();
		
	}
	
	public User findById(Long id) throws Exception {
		
		User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		
		return user;
	}
	
	public Long edit(User user) {
		
		return user.getId();
	}

}
