package com.employee.Employee_Management.serviceImpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.Employee_Management.repository.UserRepository;
import com.employee.Employee_Management.security.JwtUtil;
import com.employee.Employee_Management.dto.LoginRequest;
import com.employee.Employee_Management.dto.RegisterRequest;
import com.employee.Employee_Management.entity.User;
import com.employee.Employee_Management.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public String register(RegisterRequest request) {
		if(userRepository.existsByUsername(request.getUsername())) {
			return "Username already exists";
		}
		if(userRepository.existsByEmail(request.getEmail())) {
			return "Email already exists";
		}
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setRole(request.getRole());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		System.out.println("Before Save");

		User savedUser = userRepository.save(user);

		System.out.println("After Save");
		System.out.println(savedUser.getId());
		return "User Registered Successfully";
	}

	@Override
	public String login(LoginRequest request) {

	    try {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getUsername(),
	                        request.getPassword())
	        );

	        System.out.println("Authentication Successful");

	    } catch (Exception e) {
	        e.printStackTrace();
	        return e.getMessage();
	    }

	    User user = userRepository.findByUsername(request.getUsername())
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    return jwtUtil.generateToken(user.getUsername());
	}

	
}
