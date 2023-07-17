package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	

	}


