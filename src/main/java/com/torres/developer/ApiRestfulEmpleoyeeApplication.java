package com.torres.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.torres.developer.entity.Department;
import com.torres.developer.repository.DepartmentRepository;

@SpringBootApplication
public class ApiRestfulEmpleoyeeApplication implements ApplicationRunner{
	
	@Autowired
	private Faker faker;
	
	@Autowired
	private DepartmentRepository departmentRepository; 

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfulEmpleoyeeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		createDepartment();
		
	}
	
	public void  createDepartment() {
		for(int i = 0; i<10; i++) {
			Department department = new Department();
			department.setDepartmentName(faker.commerce().department());
			department.setDepartmentNumber(faker.stock().nsdqSymbol());
			departmentRepository.save(department);
		}
	}
	

}
