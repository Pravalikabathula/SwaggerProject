package com.rgt.swagger.SwaggerProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Object findByName(String employeeName);

	void deleteById(int id);

}
