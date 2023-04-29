package com.ibm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.model.Employee;
import com.ibm.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;

	// Home Page
	@GetMapping("/")
	public String welcome()
	{
		return "<html><body>"
			+ "<h1>WELCOME to Employee Portal</h1>"
			+ "</body></html>";
	}

	// Get All Employees
	@GetMapping("/employee")
	public List<Employee> getAllEmployees()
	{
		return repo.findAll();
	}

	// Get the employee details by
	// ID
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(
		@PathVariable(value = "id") int id)
	{
		return repo.findById(id);
	}

	// Add/Create/Update employee record
	@PostMapping("/employee")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee addEmployee(
		@RequestBody Employee employee)
	{
		return repo.save(employee);
	}

	// Delete/Remove employee record
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(
		@PathVariable(value = "id") int id)
	{
		repo.deleteById(id);
	}

	
	
}
