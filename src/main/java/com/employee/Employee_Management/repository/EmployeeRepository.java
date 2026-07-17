package com.employee.Employee_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<com.employee.Employee_Management.entity.Employee, Long> {

}
