package com.torres.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torres.developer.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
