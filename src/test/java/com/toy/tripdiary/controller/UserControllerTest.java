package com.toy.tripdiary.controller;

import static org.junit.Assert.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.toy.tripdiary.domain.User;
import com.toy.tripdiary.dto.UserDTO;
import com.toy.tripdiary.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TestRestTemplate restTemplate;

	@After
	public void end() throws Exception {
		userRepository.deleteAll();
	}
	
	@Test
	public void join() throws Exception {
		
		//given
		String email = "test01@mail.com";
		UserDTO userDTO = UserDTO.builder()
				.email(email)
				.password("test1230")
				.name("테스트")
				.nickname("테스트")
				.build();
		
		String url = "http://localhost/user/join";
		//when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, userDTO, Long.class);
		
		Optional<User> users = userRepository.findByEmail(email);
		User user = users.get();
		//then
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
		Assertions.assertThat(responseEntity.getBody()).isEqualTo(userDTO.getId());
		
		Assertions.assertThat(users).isNotEmpty();
		Assertions.assertThat(user.getEmail()).isEqualTo(email);
		
		
	}

}
