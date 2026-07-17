package com.employee.Employee_Management.controller;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee_Management.entity.Employee;
import com.employee.Employee_Management.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController (EmployeeService employeeService){
		this.employeeService = employeeService;
}
	
//	Create Employee
	
	@PostMapping
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
//	Get All Employee

	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
//	Get Employee by Id
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
		
	}
	
//	UpdateEmployee
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id,@Valid @RequestBody Employee employee) {
		return employeeService.UpdateEmployee(id, employee);
		
	}
	
//	Delete Employee
	
	@DeleteMapping("/{id}")
	
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully. ";
	}
	
//	Pagination & Sorting
	
	@GetMapping("/page")
	public Page<Employee> getEmployeesWithPagination(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy){
		return employeeService.getEmployeesWithPAgination(page, size, sortBy);
	}
	
	
	
}
