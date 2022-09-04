package com.torres.developer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.torres.developer.entity.Employee;

public interface EmployeeService {
	

	Page<Employee> getAllEmployee(Pageable page);
	
	Employee getEmployeeById(Long id);
	
	void deleteEmployeeById(Long id);
	
	Employee saveEmployeeDetails(Employee employee);
	
	Employee updateEmployeeDetails(Long id,  Employee employee);

}
