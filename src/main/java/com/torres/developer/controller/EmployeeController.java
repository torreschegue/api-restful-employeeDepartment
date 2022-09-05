package com.torres.developer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.torres.developer.entity.Employee;
import com.torres.developer.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/employee")
	public Employee saveEmployeeDetails(@Valid  @RequestBody Employee department) {
		return employeeService.saveEmployeeDetails(department);
	}
	
	@GetMapping("/employee")
	public Page<Employee> getAllEmployee(Pageable page){
		return employeeService.getAllEmployee(page);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getAllEmployeeById(@PathVariable("id")Long id){
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployeeDetails(@RequestBody Employee employee, @PathVariable Long id) {
		return employeeService.updateEmployeeDetails(id, employee);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/employee")
	public void deleteEmployee(@RequestParam("id") Long id) {
		employeeService.deleteEmployeeById(id);
	}
	
	
}
