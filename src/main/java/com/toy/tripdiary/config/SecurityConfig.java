package com.toy.tripdiary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
			.csrf().disable()
			.authorizeHttpRequests()
									.antMatchers("/").permitAll()
									.antMatchers("/users/login").permitAll()
									.antMatchers("/users/join").permitAll()
									.antMatchers("/users/**").authenticated()
									.anyRequest().authenticated()
									.and()
			.formLogin()
						.loginPage("/users/login")
						.defaultSuccessUrl("/")
						.failureUrl("/users/login")
						.usernameParameter("email")
						.loginProcessingUrl("/users/login_proc")
						.permitAll()
						.and()
			.logout()
						.logoutUrl("/users/logout")
						.logoutSuccessUrl("/")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
						.permitAll()
						.and()
			.exceptionHandling()
								.accessDeniedPage("/access_denied")
								.and()
			.userDetailsService(userDetailsService)
		;
		
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer customizer() {
		return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/icons/**", "/images/**");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}
