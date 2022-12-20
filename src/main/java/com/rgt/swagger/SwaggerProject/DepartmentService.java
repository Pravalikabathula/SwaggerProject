package com.rgt.swagger.SwaggerProject;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	Department updateDepartment(Department department, Integer departmentId);

	void deleteDepartmentById(Integer departmentId);

	List<Department> getdepartmentAddress(String address);

}
