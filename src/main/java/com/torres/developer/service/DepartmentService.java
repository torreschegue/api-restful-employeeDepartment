package com.torres.developer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.torres.developer.entity.Department;


public interface DepartmentService {
	
	Page<Department> getAllDepartment(Pageable page);
	
	Department getDepartmentById(Long id);
	
	void deleteDepartmentById(Long id);
	
	Department saveDepartmentDetails(Department department);
	
	Department updateDepartmentDetails(Long id,  Department department);

}
