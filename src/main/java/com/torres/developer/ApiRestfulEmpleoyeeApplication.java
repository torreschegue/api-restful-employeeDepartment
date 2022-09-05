package com.torres.developer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.torres.developer.entity.Department;
import com.torres.developer.entity.Employee;
import com.torres.developer.repository.DepartmentRepository;
import com.torres.developer.repository.EmployeeRepository;

@SpringBootApplication
public class ApiRestfulEmpleoyeeApplication implements ApplicationRunner{
	
	@Autowired
	private Faker faker;
	
	@Autowired
	private DepartmentRepository departmentRepository; 
	
	@Autowired
	private EmployeeRepository employeeRepository; 

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfulEmpleoyeeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		createDepartment();
		createEmployee();
		
	}
	
	public void  createDepartment() {
		for(int i = 0; i<10; i++) {
			Department department = new Department();
			department.setDepartmentName(faker.commerce().department());
			department.setDepartmentNumber(faker.stock().nsdqSymbol());
			departmentRepository.save(department);
		}
	}
	
	public void createEmployee() {
		Date myDate = new Date();
		int numero = 0;
		Long id = (long) 0;
		for(int i = 0; i<100; i++) {
			Employee employee = new Employee();
			employee.setName(faker.address().firstName());
			employee.setFatherSurname(faker.address().lastName());
			employee.setMotherSurname(faker.address().lastName());
			employee.setDateAdmissio(myDate);
			// employee.setDepartment(new Department((long) numero++));
			employee.setDepartment(new Department((long) (numero = (int)(Math.random()*10+1))));
			employeeRepository.save(employee);
			
		}
		
	}

}
