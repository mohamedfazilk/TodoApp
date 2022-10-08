package com.Qickzo.TodoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Qickzo.TodoApp.exeception.ResourceNotFoundException;
import com.Qickzo.TodoApp.model.Employee;
import com.Qickzo.TodoApp.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeerepsitory;
	
	//get All employees
	
	@GetMapping("/employees")
	public List <Employee> getAllEmployees(){
		return employeerepsitory.findAll();
	}
	
	//get employee by id
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee>getEmployeeById(@PathVariable Long id){
		Employee employee = employeerepsitory.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("employee not exist with is :"+
		id));
		return ResponseEntity.ok(employee);
	}

}
