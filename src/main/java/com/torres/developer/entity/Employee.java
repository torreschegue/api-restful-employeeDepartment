package com.torres.developer.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_employees")
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	@NotBlank(message = "name field must not be empty")
	private String name;
	
	@Column(name = "father_surname")
	@NotBlank(message = "father surname field should not be empty")
	private String fatherSurname;
	
	@Column(name = "mother_surname")
	@NotBlank(message = "mother surname field should not be empty")
	private String motherSurname;
	
	@NotNull(message = "Date must not be null")
	private Date dateAdmissio;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	
	
}
