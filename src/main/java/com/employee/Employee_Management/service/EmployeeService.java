package com.employee.Employee_Management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.employee.Employee_Management.entity.Employee;


public interface EmployeeService {
	Employee saveEmployee(Employee emaployee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long id);
	
	Employee UpdateEmployee(Long id, Employee employee);
	
	void deleteEmployee(Long id);
	
	Page<Employee> getEmployeesWithPAgination(int page, int size, String sortBy);

}
