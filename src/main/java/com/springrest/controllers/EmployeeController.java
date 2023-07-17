package com.springrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Employee;
import com.springrest.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee (@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long employeeId){
		return new ResponseEntity<Employee>(empService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	@PutMapping("employee/{id}")
	public ResponseEntity<Employee> updateEmployee (@PathVariable("id")long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee> (empService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@DeleteMapping("employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
	}
	}


