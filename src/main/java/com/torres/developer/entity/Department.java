package com.torres.developer.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "department_number")
	@NotBlank(message = "Department number field must not be null")
	@Size(min = 3, message  = "The department number field must have more than 3 characters")
	@JsonIgnore
	private String departmentNumber;
	
	@Column(name = "department_name") 
	@NotBlank(message = "Department name field must not be null")
	@Size(min = 3, message  = "The department name field must have more than 3 characters")
	private String departmentName;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	@JsonIgnore
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	@JsonIgnore
	private Timestamp updatedAt;

	public Department(Long id) {
		this.id = id;
	}
	
	
	

}
