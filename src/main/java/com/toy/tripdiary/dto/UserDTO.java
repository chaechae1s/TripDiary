package com.toy.tripdiary.dto;


import com.toy.tripdiary.domain.Role;
import com.toy.tripdiary.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDTO {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String fileName;
	private boolean enabled;
	private Role role;
	
	@Builder
	public UserDTO(Long id, String email, String password, String name, String nickname, String fileName, boolean enabled, Role role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.fileName = fileName;
		this.enabled = enabled;
		this.role = role;
	}
	
	public User toEntity() {
		return User.builder()
				.id(id)
				.email(email)
				.password(password)
				.name(name)
				.nickname(nickname)
				.enabled(enabled)
				.role(role)
				.build();
	}
	
	/* Entity -> dto */
	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.name = user.getName();
		this.nickname = user.getNickname();
		this.fileName = user.getFileName();
	}

}
