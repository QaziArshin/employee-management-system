package com.employee.Employee_Management.serviceImpl;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employee.Employee_Management.entity.Employee;
import com.employee.Employee_Management.exception.ResourceNotFoundException;
import com.employee.Employee_Management.repository.EmployeeRepository;
import com.employee.Employee_Management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeReposiroty) {
		this.employeeRepository = employeeReposiroty;
	}

//	save Employee
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Employee savedEmployee =employeeRepository.save(employee);
		System.out.print("After Save");
		System.out.print(savedEmployee.getId());
		
		return savedEmployee;
	}

//	Get All employee
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll() ;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
	}

	@Override
	public Employee UpdateEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		Employee existingEmployee = getEmployeeById(id);
		
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setPosition(employee.getPosition());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setDateOfJoining(employee.getDateOfJoining());
		
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Page<Employee> getEmployeesWithPAgination(int page, int size, String sortBy) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
	}

	

}
