package com.torres.developer.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.torres.developer.entity.Department;
import com.torres.developer.exception.ResourceNotFoundException;
import com.torres.developer.repository.DepartmentRepository;
import com.torres.developer.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Page<Department> getAllDepartment(Pageable page) {		
		return departmentRepository.findAll(page);
	}

	@Override
	public Department getDepartmentById(Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isPresent()) {
			return department.get();
		}
		throw new ResourceNotFoundException("Department is not found for the id : " + id);
	}

	@Override
	public void deleteDepartmentById(Long id) {
		Department department = getDepartmentById(id);
		departmentRepository.delete(department);
	}

	@Override
	public Department saveDepartmentDetails(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartmentDetails(Long id, Department department) {
		Department departmentUpdate = getDepartmentById(id);
		departmentUpdate.setDepartmentName(department.getDepartmentName() != null ? department.getDepartmentName() : departmentUpdate.getDepartmentName());
		departmentUpdate.setDepartmentNumber(department.getDepartmentNumber()!= null ? department.getDepartmentName() : departmentUpdate.getDepartmentNumber());
		return departmentRepository.save(departmentUpdate);
	}
	
	
	
	

}
