package com.rgt.swagger.SwaggerProject;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*
	 * public EmployeeServiceImpl(EmployeeRepository employeeRepository) { super();
	 * this.employeeRepository = employeeRepository; }
	 */

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> optional = employeeRepository.findById((long) id);
		Employee employee = optional.get();
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public boolean isEmployeeExist(Long id) {
		return employeeRepository.existsById(id);
	}

	@Override
	public EmployeeService getEmployee(String employeeName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEmployeeExist(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
