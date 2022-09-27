package com.toy.tripdiary.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.toy.tripdiary.domain.User;
import com.toy.tripdiary.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> findUser = userRepository.findByEmail(username);
		
		if(!findUser.isPresent()) {
			throw new UsernameNotFoundException("존재하지 않는 사용자입니다.");
		}
		
		return new SecurityUser(findUser.get());
	}

}
