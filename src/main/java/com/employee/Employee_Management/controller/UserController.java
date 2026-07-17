package com.employee.Employee_Management.controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee_Management.dto.LoginRequest;
import com.employee.Employee_Management.dto.RegisterRequest;
import com.employee.Employee_Management.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService =userService;
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody LoginRequest request) {
		System.out.println("========= Login API HIT =========");
		return userService.login(request);
	}
}
