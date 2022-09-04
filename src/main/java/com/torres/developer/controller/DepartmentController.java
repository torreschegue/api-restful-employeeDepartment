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

import com.torres.developer.entity.Department;
import com.torres.developer.service.DepartmentService;


@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService; 
	
	// controller create
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/department")
	public Department saveDepartmentDetails(@Valid  @RequestBody Department department) {
		return departmentService.saveDepartmentDetails(department);
	}
	
	// controller get all
	@GetMapping("/department")
	public Page<Department> getAllDepartment(Pageable page){
		return departmentService.getAllDepartment(page);
	}
	
	// controller get by id
	@GetMapping("/department/{id}")
	public Department getDepartmentById(@PathVariable("id")Long id) {
		return  departmentService.getDepartmentById(id);
	}
	
	// Controller Update Entity
	@PutMapping("/department/{id}")
	public Department updateDepartmentDetails(@RequestBody Department department, @PathVariable Long id) {
		return departmentService.updateDepartmentDetails(id, department);
	}
	
	// Controller Delete Entity
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/department")
	public void deleteExpenseById(@RequestParam("id") Long id) {
		departmentService.deleteDepartmentById(id);		
	};
	
	
}
