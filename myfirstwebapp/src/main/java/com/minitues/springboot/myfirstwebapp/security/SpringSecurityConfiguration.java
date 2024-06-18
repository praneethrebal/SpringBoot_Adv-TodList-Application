package com.minitues.springboot.myfirstwebapp.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
//	InMemoryUserDetailsManager(UserDetails.. user)
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager(PasswordEncoder passwordEncoder) {
//		String username="in28min";
//		String password="dummy";
	    UserDetails userDetails1 = createNewUser(passwordEncoder, "in28min", "dummy");
	    UserDetails userDetails2 =createNewUser(passwordEncoder, "appu", "appu");

	    return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}


	private UserDetails createNewUser(PasswordEncoder passwordEncoder, String username, String password) {
		Function<String, String> passwordEncoderFunction = input -> passwordEncoder.encode(input);

	    UserDetails userDetails = User.builder()
	            .passwordEncoder(passwordEncoderFunction::apply)
	            .username(username)
	            .password(password)
	            .roles("USER", "ADMIN")
	            .build();
		return userDetails;
	}

	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(
			auth -> auth.anyRequest().authenticated()
		);
		http.formLogin(withDefaults());


		http.csrf().disable();
		http.headers().frameOptions().disable();
		

		return http.build();
	}
}
