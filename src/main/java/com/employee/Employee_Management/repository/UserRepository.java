package com.employee.Employee_Management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.Employee_Management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String name);
	
	boolean existsByUsername(String name);
	
	boolean existsByEmail(String name);
	
	
		
}
