package com.torres.developer.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.torres.developer.entity.Employee;
import com.torres.developer.exception.ResourceNotFoundException;
import com.torres.developer.repository.EmployeeRepository;
import com.torres.developer.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Page<Employee> getAllEmployee(Pageable page) {
		return employeeRepository.findAll(page);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new ResourceNotFoundException("Employee is not found for the id : " + id);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employee employee = getEmployeeById(id);
		employeeRepository.delete(employee);
	}

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployeeDetails(Long id, Employee employee) {
		Employee employeeUpdate = getEmployeeById(id);
		 employeeUpdate.setName(employee.getName() != null ? employee.getName() : employeeUpdate.getName());
		 employeeUpdate.setFatherSurname(employee.getFatherSurname() != null ? employee.getFatherSurname() : employeeUpdate.getFatherSurname());
		 employeeUpdate.setMotherSurname(employee.getMotherSurname() != null ? employee.getMotherSurname() : employeeUpdate.getMotherSurname()); 
		return employeeUpdate;
	}

}
