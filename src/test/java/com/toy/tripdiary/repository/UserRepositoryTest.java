package com.toy.tripdiary.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.toy.tripdiary.domain.Role;
import com.toy.tripdiary.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	@Rollback(false)
	public void save() throws Exception {
		
		User user = new User();
		user.setEmail("admin@tripdiary.com");
		user.setPassword(passwordEncoder.encode("admin1234"));
		user.setName("admin");
		user.setNickname("관리자");
		user.setEnabled(true);
		user.setRole(Role.ROLE_ADMIN);

		
		userRepository.save(user);

	}

}
