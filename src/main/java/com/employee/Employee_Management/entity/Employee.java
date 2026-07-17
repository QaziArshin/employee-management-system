package com.employee.Employee_Management.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name ="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank(message ="name is required")
	 @Column(nullable = false)
	private String name;
	
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "Department is required")
	private String department;
	
	@NotBlank
	private String position;
	
	@Positive(message = "Salary must be greater than 0")
	private Double salary;
	
	private LocalDate dateOfJoining;
	
	public Employee() {
		
	}
	public Employee(Long id, String name, String email, String department, String position, Double salary,
			LocalDate dateOfJoining) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.position = position;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", possition=" + position + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining + "]";
	}
	
	
	

}
