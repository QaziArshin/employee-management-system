package com.employee.Employee_Management.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.Employee_Management.entity.User;

import com.employee.Employee_Management.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> 
				new UsernameNotFoundException("User not found"));
		
		System.out.println("Username : " + user.getUsername());
		System.out.println("Role : " + user.getRole());
		System.out.println("Password : " + user.getPassword());
		
			return org.springframework.security.core.userdetails.User
					.withUsername(user.getUsername())
					.password(user.getPassword())
					.roles(user.getRole())
					.build();
		
	}

}
