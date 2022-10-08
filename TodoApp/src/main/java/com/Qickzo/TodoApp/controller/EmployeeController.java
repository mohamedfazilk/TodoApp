package com.Qickzo.TodoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
