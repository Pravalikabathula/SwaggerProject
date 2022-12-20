package com.rgt.swagger.SwaggerProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	/*
	 * Department save(Department department);
	 * 
	 * List<Department> findAll();
	 * 
	 * Department findById(Long departmentId);
	 * 
	 * void deleteById(Long departmentId);
	 */

}
