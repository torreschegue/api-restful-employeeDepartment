package com.torres.developer.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.torres.developer.entity.Employee;
import com.torres.developer.repository.EmployeeRepository;
import com.torres.developer.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empleyeeRepositoty;

	@Override
	public Page<Employee> getAllEmployee(Pageable page) {
		return empleyeeRepositoty.findAll(page);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployeeDetails(Long id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
