package com.rgt.swagger.SwaggerProject;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

	public abstract Employee createEmployee(Employee employee);

	public abstract void updateEmployee(Employee employee);

	public abstract Employee getEmployee(int id);

	public abstract List<Employee> getEmployees();

	public abstract void deleteEmployee(int id);

	public abstract boolean isEmployeeExist(int id);

	public abstract EmployeeService getEmployee(String employeeName);

	boolean isEmployeeExist(Long id);

	public abstract List<Employee> getAllEmployee();
	


}
