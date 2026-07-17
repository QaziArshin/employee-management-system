package com.employee.Employee_Management.service;

import com.employee.Employee_Management.dto.LoginRequest;
import com.employee.Employee_Management.dto.RegisterRequest;

public interface UserService {
 
	String register(RegisterRequest request);
	
	String login(LoginRequest request);
	
	
}
