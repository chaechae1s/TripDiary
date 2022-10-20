package com.toy.tripdiary.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.tripdiary.domain.User;
import com.toy.tripdiary.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Transactional
	public void join(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		
		userRepository.save(user);
		
	}
	
	@Transactional
	public void edit(User user) {
		User persistance = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다."));

		persistance.setNickname(user.getNickname());
		persistance.setFileName(user.getFileName());	
		
	}
	
	public User findById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다."));
		return user;
	}
	
	public void delete(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다."));
		
		userRepository.delete(user);
	}

}
